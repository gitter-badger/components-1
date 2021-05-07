/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : ComplexButton.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.fentity.vo.menu;

import java.util.Arrays;

public class ComplexButton extends Button {
    private Button[] sub_button;

    public Button[] getSub_button() {
        return this.sub_button;
    }

    public void setSub_button(Button[] sub_button) {
        this.sub_button = sub_button;
    }

    @Override
    public String toString() {
        return "ComplexButton{" + "sub_button=" + Arrays.toString(sub_button) + '}';
    }
}
