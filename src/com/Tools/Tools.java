package com.Tools;

import java.awt.*;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;

public class Tools {
	//字体样式
	public static Font  mainFont = new Font("宋体", Font.PLAIN, 15);
	public static Font  f_12 = new Font("宋体", Font.PLAIN, 12);
	public static Font  f_14 = new Font("宋体", Font.PLAIN, 14);
	public static Font  heightLight = new Font("宋体", Font.PLAIN, 25);
	public static int  width = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	public static String name = "";
	public static String position = "";
	public static TitledBorder getTitleBorder(String title)
	{
		TitledBorder titleBorder=BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.GRAY,2),
				title,TitledBorder.LEFT,TitledBorder.TOP,Tools.f_14);
		return titleBorder;
	}
	public static Color colorWhite = new Color(255, 255, 255);
	public static Color colorGray = new Color(230, 230, 230);
	public static String nowDate;
}
