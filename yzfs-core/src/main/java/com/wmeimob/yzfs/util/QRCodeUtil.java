package com.wmeimob.yzfs.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.wmeimob.yzfs.qiniu.QiniuUtil;
import com.wmeimob.yzfs.weixin.WeChatUtil;

public class QRCodeUtil {

	private static final int BLACK = 0xFF000000;
	private static final int WHITE = 0xFFFFFFFF;

	private QRCodeUtil() {
	}

	public static BufferedImage toBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
			}
		}
		return image;
	}

	public static void writeToFile(BitMatrix matrix, String format, File file) throws IOException {
		BufferedImage image = toBufferedImage(matrix);
		if (!ImageIO.write(image, format, file)) {
			throw new IOException("Could not write an image of format " + format + " to " + file);
		}
	}

	public static void writeToStream(BitMatrix matrix, String format, OutputStream stream) throws IOException {
		BufferedImage image = toBufferedImage(matrix);
		if (!ImageIO.write(image, format, stream)) {
			throw new IOException("Could not write an image of format " + format);
		}
	}

	/**
	 * 创建个人二维码并上传到七牛
	 * 
	 * @param pUserId
	 * @return key
	 */
	public static String createPersonalQRCode(String content) {
		ByteArrayInputStream qrcodeStream = QRCodeUtil.getQRcodeByteArrayInputStream(content);
		return QiniuUtil.uploadStream(qrcodeStream);
	}

	/**
	 * 生成并返回二维码图片的ByteArrayInputStream
	 * 
	 * @param content
	 * @return
	 */
	public static ByteArrayInputStream getQRcodeByteArrayInputStream(String content) {
		try {
			MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
			Map hints = new HashMap();
			// 内容所使用编码
			hints.put(EncodeHintType.CHARACTER_SET, "gb2312");
			BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, 200, 200, hints);
			// 生成二维码
			File outputFile = new File("temp.jpg");
			QRCodeUtil.writeToFile(bitMatrix, "jpg", outputFile);

			// 读取本地图片输入流
			FileInputStream inputStream = new FileInputStream(outputFile.getAbsoluteFile());
			int i = inputStream.available();
			// byte数组用于存放图片字节数据
			byte[] buff = new byte[i];
			inputStream.read(buff);
			// 记得关闭输入流
			inputStream.close();
			return new ByteArrayInputStream(buff);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
