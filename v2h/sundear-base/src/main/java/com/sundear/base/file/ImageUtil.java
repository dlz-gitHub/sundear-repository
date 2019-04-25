package com.sundear.base.file;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ImageUtil {
	/**
	 * 缩放图片方法
	 * 
	 * @param srcImageFile
	 *            要缩放的图片路径
	 * @param result
	 *            缩放后的图片路径
	 * @param height
	 *            目标高度像素
	 * @param width
	 *            目标宽度像素
	 * @param bb
	 *            是否补白
	 */
	public final static void scale(String srcImageFile, String result, int height, int width, boolean bb) {
		try {
			double ratio = 0.0; // 缩放比例
			File f = new File(srcImageFile);
			BufferedImage bi = ImageIO.read(f);
			Image itemp = bi.getScaledInstance(width, height, Image.SCALE_SMOOTH);// bi.SCALE_SMOOTH 选择图像平滑度比缩放速度具有更高优先级的图像缩放算法。
			// 计算比例
			if ((bi.getHeight() > height) || (bi.getWidth() > width)) {
				double ratioHeight = (new Integer(height)).doubleValue() / bi.getHeight();
				double ratioWhidth = (new Integer(width)).doubleValue() / bi.getWidth();
				if (ratioHeight > ratioWhidth) {
					ratio = ratioHeight;
				} else {
					ratio = ratioWhidth;
				}
				AffineTransformOp op = new AffineTransformOp(AffineTransform// 仿射转换
						.getScaleInstance(ratio, ratio), null);// 返回表示剪切变换的变换
				itemp = op.filter(bi, null);// 转换源 BufferedImage 并将结果存储在目标 BufferedImage 中。
			}
			if (bb) {// 补白
				BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);// 构造一个类型为预定义图像类型之一的 BufferedImage。
				Graphics2D g = image.createGraphics();// 创建一个 Graphics2D，可以将它绘制到此 BufferedImage 中。
				g.setColor(Color.white);// 控制颜色
				g.fillRect(0, 0, width, height);// 使用 Graphics2D 上下文的设置，填充 Shape 的内部区域。
				if (width == itemp.getWidth(null))
					g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2, itemp.getWidth(null), itemp.getHeight(null), Color.white, null);
				else
					g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0, itemp.getWidth(null), itemp.getHeight(null), Color.white, null);
				g.dispose();
				itemp = image;
			}
			ImageIO.write((BufferedImage) itemp, "JPEG", new File(result)); // 输出压缩图片
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 裁剪图片方法
	 * 
	 * @param bufferedImage
	 *            图像源
	 * @param startX
	 *            裁剪开始x坐标
	 * @param startY
	 *            裁剪开始y坐标
	 * @param endX
	 *            裁剪结束x坐标
	 * @param endY
	 *            裁剪结束y坐标
	 * @return
	 */
	public static BufferedImage cropImage(BufferedImage bufferedImage, int startX, int startY, int endX, int endY) {
		int width = bufferedImage.getWidth();
		int height = bufferedImage.getHeight();
		if (startX == -1) {
			startX = 0;
		}
		if (startY == -1) {
			startY = 0;
		}
		if (endX == -1) {
			endX = width - 1;
		}
		if (endY == -1) {
			endY = height - 1;
		}
		BufferedImage result = new BufferedImage(endX - startX, endY - startY, 4);
		for (int x = startX; x < endX; ++x) {
			for (int y = startY; y < endY; ++y) {
				int rgb = bufferedImage.getRGB(x, y);
				result.setRGB(x - startX, y - startY, rgb);
			}
		}
		return result;
	}

	public static boolean createThumbnail(String fromFileStr, String saveToFileStr, String sysimgfile, String suffix, int width, int height) {
		// fileExtNmae是图片的格式 gif JPG 或png
		// String fileExtNmae="";
		File F = new File(fromFileStr);
		if (!F.isFile())
			return false;
		File ThF = new File(saveToFileStr, sysimgfile + "." + suffix);
		BufferedImage buffer;
		try {
			buffer = ImageIO.read(F);
			/*
			 * 核心算法，计算图片的压缩比
			 */
			int w = buffer.getWidth();
			int h = buffer.getHeight();
			double ratiox = 1.0d;
			double ratioy = 1.0d;

			ratiox = w * ratiox / width;
			ratioy = h * ratioy / height;

			if (ratiox >= 1) {
				if (ratioy < 1) {
					ratiox = height * 1.0 / h;
				} else {
					if (ratiox > ratioy) {
						ratiox = height * 1.0 / h;
					} else {
						ratiox = width * 1.0 / w;
					}
				}
			} else {
				if (ratioy < 1) {
					if (ratiox > ratioy) {
						ratiox = height * 1.0 / h;
					} else {
						ratiox = width * 1.0 / w;
					}
				} else {
					ratiox = width * 1.0 / w;
				}
			}
			/*
			 * 对于图片的放大或缩小倍数计算完成，ratiox大于1，则表示放大，否则表示缩小
			 */
			AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratiox, ratiox), null);
			buffer = op.filter(buffer, null);
			// 从放大的图像中心截图
			buffer = buffer.getSubimage((buffer.getWidth() - width) / 2, (buffer.getHeight() - height) / 2, width, height);
			ImageIO.write(buffer, suffix, ThF);
			buffer=null;
			ThF=null;
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
	
	public static BufferedImage createThumbnail(InputStream inputStream, int width, int height) {
		BufferedImage buffer;
		try {
			buffer = ImageIO.read(inputStream);
			/*
			 * 核心算法，计算图片的压缩比
			 */
			int w = buffer.getWidth();
			int h = buffer.getHeight();
			double ratiox = 1.0d;
			double ratioy = 1.0d;

			ratiox = w * ratiox / width;
			ratioy = h * ratioy / height;

			if (ratiox >= 1) {
				if (ratioy < 1) {
					ratiox = height * 1.0 / h;
				} else {
					if (ratiox > ratioy) {
						ratiox = height * 1.0 / h;
					} else {
						ratiox = width * 1.0 / w;
					}
				}
			} else {
				if (ratioy < 1) {
					if (ratiox > ratioy) {
						ratiox = height * 1.0 / h;
					} else {
						ratiox = width * 1.0 / w;
					}
				} else {
					ratiox = width * 1.0 / w;
				}
			}
			/*
			 * 对于图片的放大或缩小倍数计算完成，ratiox大于1，则表示放大，否则表示缩小
			 */
			AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratiox, ratiox), null);
			buffer = op.filter(buffer, null);
			// 从放大的图像中心截图
			buffer = buffer.getSubimage((buffer.getWidth() - width) / 2, (buffer.getHeight() - height) / 2, width, height);
			return buffer;
		} catch (Exception ex) {
			return null;
		}
	}
}
