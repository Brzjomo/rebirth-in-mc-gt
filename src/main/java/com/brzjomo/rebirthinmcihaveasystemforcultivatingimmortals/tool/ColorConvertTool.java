package com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.tool;

public class ColorConvertTool {
    public static String getColorFromInt(int colorNum) {
        int R = (colorNum >> 16 & 0xFF);
        int G = (colorNum >> 8 & 0xFF);
        int B = (colorNum & 0xFF);
        int A = (colorNum >> 24 & 0xFF);

        return R + "," + G + "," + B + "," + A;
    }

    public static int convertRGBAToInt(int R, int G, int B, int A) {
        R <<= 16;
        G <<= 8;
        A <<= 24;

        return R + G + B + A;
    }

    public static int convertRGBTextToInt(String colorText) {
        String[] colorValue = colorText.split(",");

        int R = Integer.parseInt(colorValue[0]);
        int G = Integer.parseInt(colorValue[1]);
        int B = Integer.parseInt(colorValue[2]);
        int A = 0;

        return ColorConvertTool.convertRGBAToInt(R, G, B, A);
    }
}
