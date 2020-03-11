package LINTCODE3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LINTCODE238 {

    /*Description
    * 一个黑白显示屏由一个单独的字节数组组成，这个屏幕允许 8 个连续像素由一个字节进行存储。该显示屏宽 w ，
    * 被分割为 8 （也就是说，任意字节都不可能被行切断）。该显示屏高，则取决于数组的长度及显示屏的宽。请设计一个函数 drawHorizontalLine(byte[] screen, int width,
    * int x1, int x2, int y) 从(x1, y) 到 (x2, y) 画出一条水平线。
    * */

    public void drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y) {
        int start_offset = x1 % 8;
        int first_full_byte = x1 / 8;
        if (start_offset != 0) {
            first_full_byte++;
        }

        int end_offset = x2 % 8;
        int last_full_byte = x2 / 8;
        if (end_offset != 7) {
            last_full_byte--;
        }

        for (int b = first_full_byte; b <= last_full_byte; b++) {
            screen[(width / 8) * y + b] = (byte) 0xFF;
        }

        byte start_mask = (byte) (0xFF >> start_offset);
        byte end_mask = (byte) ~(0xFF >> (end_offset +1));
        if ((x1 / 8) == (x2 / 8)) {
            byte mask = (byte) (start_mask & end_mask);
            screen[(width / 8) * y + (x1 / 8)] |= mask;
        } else {
            if (start_offset != 0) {
                int byte_number = (width / 8) * y + first_full_byte - 1;
                screen[byte_number] |= start_mask;
            }

            if (end_offset != 7) {
                int byte_number = (width / 8) * y + last_full_byte + 1;
                screen[byte_number] |= end_mask;
            }
        }
    }

}
