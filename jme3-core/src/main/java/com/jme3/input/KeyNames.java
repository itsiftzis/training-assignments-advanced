/*
 * Copyright (c) 2009-2012 jMonkeyEngine
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'jMonkeyEngine' nor the names of its contributors
 *   may be used to endorse or promote products derived from this software
 *   without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.jme3.input;

import static com.jme3.input.KeyInput.KEY_0;
import static com.jme3.input.KeyInput.KEY_1;
import static com.jme3.input.KeyInput.KEY_2;
import static com.jme3.input.KeyInput.KEY_3;
import static com.jme3.input.KeyInput.KEY_4;
import static com.jme3.input.KeyInput.KEY_5;
import static com.jme3.input.KeyInput.KEY_6;
import static com.jme3.input.KeyInput.KEY_7;
import static com.jme3.input.KeyInput.KEY_8;
import static com.jme3.input.KeyInput.KEY_9;
import static com.jme3.input.KeyInput.KEY_A;
import static com.jme3.input.KeyInput.KEY_ADD;
import static com.jme3.input.KeyInput.KEY_APOSTROPHE;
import static com.jme3.input.KeyInput.KEY_APPS;
import static com.jme3.input.KeyInput.KEY_AT;
import static com.jme3.input.KeyInput.KEY_AX;
import static com.jme3.input.KeyInput.KEY_B;
import static com.jme3.input.KeyInput.KEY_BACK;
import static com.jme3.input.KeyInput.KEY_BACKSLASH;
import static com.jme3.input.KeyInput.KEY_C;
import static com.jme3.input.KeyInput.KEY_CAPITAL;
import static com.jme3.input.KeyInput.KEY_CIRCUMFLEX;
import static com.jme3.input.KeyInput.KEY_COLON;
import static com.jme3.input.KeyInput.KEY_COMMA;
import static com.jme3.input.KeyInput.KEY_CONVERT;
import static com.jme3.input.KeyInput.KEY_D;
import static com.jme3.input.KeyInput.KEY_DECIMAL;
import static com.jme3.input.KeyInput.KEY_DELETE;
import static com.jme3.input.KeyInput.KEY_DIVIDE;
import static com.jme3.input.KeyInput.KEY_DOWN;
import static com.jme3.input.KeyInput.KEY_E;
import static com.jme3.input.KeyInput.KEY_END;
import static com.jme3.input.KeyInput.KEY_EQUALS;
import static com.jme3.input.KeyInput.KEY_ESCAPE;
import static com.jme3.input.KeyInput.KEY_F;
import static com.jme3.input.KeyInput.KEY_F1;
import static com.jme3.input.KeyInput.KEY_F10;
import static com.jme3.input.KeyInput.KEY_F11;
import static com.jme3.input.KeyInput.KEY_F12;
import static com.jme3.input.KeyInput.KEY_F13;
import static com.jme3.input.KeyInput.KEY_F14;
import static com.jme3.input.KeyInput.KEY_F15;
import static com.jme3.input.KeyInput.KEY_F2;
import static com.jme3.input.KeyInput.KEY_F3;
import static com.jme3.input.KeyInput.KEY_F4;
import static com.jme3.input.KeyInput.KEY_F5;
import static com.jme3.input.KeyInput.KEY_F6;
import static com.jme3.input.KeyInput.KEY_F7;
import static com.jme3.input.KeyInput.KEY_F8;
import static com.jme3.input.KeyInput.KEY_F9;
import static com.jme3.input.KeyInput.KEY_G;
import static com.jme3.input.KeyInput.KEY_GRAVE;
import static com.jme3.input.KeyInput.KEY_H;
import static com.jme3.input.KeyInput.KEY_HOME;
import static com.jme3.input.KeyInput.KEY_I;
import static com.jme3.input.KeyInput.KEY_INSERT;
import static com.jme3.input.KeyInput.KEY_J;
import static com.jme3.input.KeyInput.KEY_K;
import static com.jme3.input.KeyInput.KEY_KANA;
import static com.jme3.input.KeyInput.KEY_KANJI;
import static com.jme3.input.KeyInput.KEY_L;
import static com.jme3.input.KeyInput.KEY_LBRACKET;
import static com.jme3.input.KeyInput.KEY_LCONTROL;
import static com.jme3.input.KeyInput.KEY_LEFT;
import static com.jme3.input.KeyInput.KEY_LMENU;
import static com.jme3.input.KeyInput.KEY_LMETA;
import static com.jme3.input.KeyInput.KEY_LSHIFT;
import static com.jme3.input.KeyInput.KEY_M;
import static com.jme3.input.KeyInput.KEY_MINUS;
import static com.jme3.input.KeyInput.KEY_MULTIPLY;
import static com.jme3.input.KeyInput.KEY_N;
import static com.jme3.input.KeyInput.KEY_NOCONVERT;
import static com.jme3.input.KeyInput.KEY_NUMLOCK;
import static com.jme3.input.KeyInput.KEY_NUMPAD0;
import static com.jme3.input.KeyInput.KEY_NUMPAD1;
import static com.jme3.input.KeyInput.KEY_NUMPAD2;
import static com.jme3.input.KeyInput.KEY_NUMPAD3;
import static com.jme3.input.KeyInput.KEY_NUMPAD4;
import static com.jme3.input.KeyInput.KEY_NUMPAD5;
import static com.jme3.input.KeyInput.KEY_NUMPAD6;
import static com.jme3.input.KeyInput.KEY_NUMPAD7;
import static com.jme3.input.KeyInput.KEY_NUMPAD8;
import static com.jme3.input.KeyInput.KEY_NUMPAD9;
import static com.jme3.input.KeyInput.KEY_NUMPADCOMMA;
import static com.jme3.input.KeyInput.KEY_NUMPADENTER;
import static com.jme3.input.KeyInput.KEY_NUMPADEQUALS;
import static com.jme3.input.KeyInput.KEY_O;
import static com.jme3.input.KeyInput.KEY_P;
import static com.jme3.input.KeyInput.KEY_PAUSE;
import static com.jme3.input.KeyInput.KEY_PERIOD;
import static com.jme3.input.KeyInput.KEY_PGDN;
import static com.jme3.input.KeyInput.KEY_PGUP;
import static com.jme3.input.KeyInput.KEY_POWER;
import static com.jme3.input.KeyInput.KEY_Q;
import static com.jme3.input.KeyInput.KEY_R;
import static com.jme3.input.KeyInput.KEY_RBRACKET;
import static com.jme3.input.KeyInput.KEY_RCONTROL;
import static com.jme3.input.KeyInput.KEY_RETURN;
import static com.jme3.input.KeyInput.KEY_RIGHT;
import static com.jme3.input.KeyInput.KEY_RMENU;
import static com.jme3.input.KeyInput.KEY_RMETA;
import static com.jme3.input.KeyInput.KEY_RSHIFT;
import static com.jme3.input.KeyInput.KEY_S;
import static com.jme3.input.KeyInput.KEY_SCROLL;
import static com.jme3.input.KeyInput.KEY_SEMICOLON;
import static com.jme3.input.KeyInput.KEY_SLASH;
import static com.jme3.input.KeyInput.KEY_SLEEP;
import static com.jme3.input.KeyInput.KEY_SPACE;
import static com.jme3.input.KeyInput.KEY_STOP;
import static com.jme3.input.KeyInput.KEY_SUBTRACT;
import static com.jme3.input.KeyInput.KEY_SYSRQ;
import static com.jme3.input.KeyInput.KEY_T;
import static com.jme3.input.KeyInput.KEY_TAB;
import static com.jme3.input.KeyInput.KEY_U;
import static com.jme3.input.KeyInput.KEY_UNDERLINE;
import static com.jme3.input.KeyInput.KEY_UNKNOWN;
import static com.jme3.input.KeyInput.KEY_UNLABELED;
import static com.jme3.input.KeyInput.KEY_UP;
import static com.jme3.input.KeyInput.KEY_V;
import static com.jme3.input.KeyInput.KEY_W;
import static com.jme3.input.KeyInput.KEY_X;
import static com.jme3.input.KeyInput.KEY_Y;
import static com.jme3.input.KeyInput.KEY_YEN;
import static com.jme3.input.KeyInput.KEY_Z;

public class KeyNames {

    private static final String[] KEY_NAMES = new String[0xFF];

    static {
        KEY_NAMES[KEY_UNKNOWN] = "Unknown";
        KEY_NAMES[KEY_0] = "0";
        KEY_NAMES[KEY_1] = "1";
        KEY_NAMES[KEY_2] = "2";
        KEY_NAMES[KEY_3] = "3";
        KEY_NAMES[KEY_4] = "4";
        KEY_NAMES[KEY_5] = "5";
        KEY_NAMES[KEY_6] = "6";
        KEY_NAMES[KEY_7] = "7";
        KEY_NAMES[KEY_8] = "8";
        KEY_NAMES[KEY_9] = "9";

        KEY_NAMES[KEY_Q] = "Q";
        KEY_NAMES[KEY_W] = "W";
        KEY_NAMES[KEY_E] = "E";
        KEY_NAMES[KEY_R] = "R";
        KEY_NAMES[KEY_T] = "T";
        KEY_NAMES[KEY_Y] = "Y";
        KEY_NAMES[KEY_U] = "U";
        KEY_NAMES[KEY_I] = "I";
        KEY_NAMES[KEY_O] = "O";
        KEY_NAMES[KEY_P] = "P";
        KEY_NAMES[KEY_A] = "A";
        KEY_NAMES[KEY_S] = "S";
        KEY_NAMES[KEY_D] = "D";
        KEY_NAMES[KEY_F] = "F";
        KEY_NAMES[KEY_G] = "G";
        KEY_NAMES[KEY_H] = "H";
        KEY_NAMES[KEY_J] = "J";
        KEY_NAMES[KEY_K] = "K";
        KEY_NAMES[KEY_L] = "L";
        KEY_NAMES[KEY_Z] = "Z";
        KEY_NAMES[KEY_X] = "X";
        KEY_NAMES[KEY_C] = "C";
        KEY_NAMES[KEY_V] = "V";
        KEY_NAMES[KEY_B] = "B";
        KEY_NAMES[KEY_N] = "N";
        KEY_NAMES[KEY_M] = "M";

        KEY_NAMES[KEY_F1] = "F1";
        KEY_NAMES[KEY_F2] = "F2";
        KEY_NAMES[KEY_F3] = "F3";
        KEY_NAMES[KEY_F4] = "F4";
        KEY_NAMES[KEY_F5] = "F5";
        KEY_NAMES[KEY_F6] = "F6";
        KEY_NAMES[KEY_F7] = "F7";
        KEY_NAMES[KEY_F8] = "F8";
        KEY_NAMES[KEY_F9] = "F9";
        KEY_NAMES[KEY_F10] = "F10";
        KEY_NAMES[KEY_F11] = "F11";
        KEY_NAMES[KEY_F12] = "F12";
        KEY_NAMES[KEY_F13] = "F13";
        KEY_NAMES[KEY_F14] = "F14";
        KEY_NAMES[KEY_F15] = "F15";

        KEY_NAMES[KEY_NUMPAD0] = "Numpad 0";
        KEY_NAMES[KEY_NUMPAD1] = "Numpad 1";
        KEY_NAMES[KEY_NUMPAD2] = "Numpad 2";
        KEY_NAMES[KEY_NUMPAD3] = "Numpad 3";
        KEY_NAMES[KEY_NUMPAD4] = "Numpad 4";
        KEY_NAMES[KEY_NUMPAD5] = "Numpad 5";
        KEY_NAMES[KEY_NUMPAD6] = "Numpad 6";
        KEY_NAMES[KEY_NUMPAD7] = "Numpad 7";
        KEY_NAMES[KEY_NUMPAD8] = "Numpad 8";
        KEY_NAMES[KEY_NUMPAD9] = "Numpad 9";

        KEY_NAMES[KEY_NUMPADEQUALS] = "Numpad =";
        KEY_NAMES[KEY_NUMPADENTER] = "Numpad Enter";
        KEY_NAMES[KEY_NUMPADCOMMA] = "Numpad ,";
        KEY_NAMES[KEY_DIVIDE] = "Numpad /";
        KEY_NAMES[KEY_SUBTRACT] = "Numpad -";
        KEY_NAMES[KEY_DECIMAL] = "Numpad .";

        KEY_NAMES[KEY_LMENU] = "Left Alt";
        KEY_NAMES[KEY_RMENU] = "Right Alt";

        KEY_NAMES[KEY_LCONTROL] = "Left Ctrl";
        KEY_NAMES[KEY_RCONTROL] = "Right Ctrl";

        KEY_NAMES[KEY_LSHIFT] = "Left Shift";
        KEY_NAMES[KEY_RSHIFT] = "Right Shift";

        KEY_NAMES[KEY_LMETA] = "Left Option";
        KEY_NAMES[KEY_RMETA] = "Right Option";

        KEY_NAMES[KEY_MINUS] = "-";
        KEY_NAMES[KEY_EQUALS] = "=";
        KEY_NAMES[KEY_LBRACKET] = "[";
        KEY_NAMES[KEY_RBRACKET] = "]";
        KEY_NAMES[KEY_SEMICOLON] = ";";
        KEY_NAMES[KEY_APOSTROPHE] = "'";
        KEY_NAMES[KEY_GRAVE] = "`";
        KEY_NAMES[KEY_BACKSLASH] = "\\";
        KEY_NAMES[KEY_COMMA] = ",";
        KEY_NAMES[KEY_PERIOD] = ".";
        KEY_NAMES[KEY_SLASH] = "/";
        KEY_NAMES[KEY_MULTIPLY] = "*";
        KEY_NAMES[KEY_ADD] = "+";
        KEY_NAMES[KEY_COLON] = ":";
        KEY_NAMES[KEY_UNDERLINE] = "_";
        KEY_NAMES[KEY_AT] = "@";

        KEY_NAMES[KEY_APPS] = "Apps";
        KEY_NAMES[KEY_POWER] = "Power";
        KEY_NAMES[KEY_SLEEP] = "Sleep";

        KEY_NAMES[KEY_STOP] = "Stop";
        KEY_NAMES[KEY_ESCAPE] = "Esc";
        KEY_NAMES[KEY_RETURN] = "Enter";
        KEY_NAMES[KEY_SPACE] = "Space";
        KEY_NAMES[KEY_BACK] = "Backspace";
        KEY_NAMES[KEY_TAB] = "Tab";

        KEY_NAMES[KEY_SYSRQ] = "SysRq";
        KEY_NAMES[KEY_PAUSE] = "Pause";

        KEY_NAMES[KEY_HOME] = "Home";
        KEY_NAMES[KEY_PGUP] = "Page Up";
        KEY_NAMES[KEY_PGDN] = "Page Down";
        KEY_NAMES[KEY_END] = "End";
        KEY_NAMES[KEY_INSERT] = "Insert";
        KEY_NAMES[KEY_DELETE] = "Delete";

        KEY_NAMES[KEY_UP] = "Up";
        KEY_NAMES[KEY_LEFT] = "Left";
        KEY_NAMES[KEY_RIGHT] = "Right";
        KEY_NAMES[KEY_DOWN] = "Down";

        KEY_NAMES[KEY_NUMLOCK] = "Num Lock";
        KEY_NAMES[KEY_CAPITAL] = "Caps Lock";
        KEY_NAMES[KEY_SCROLL] = "Scroll Lock";

        KEY_NAMES[KEY_KANA] = "Kana";
        KEY_NAMES[KEY_CONVERT] = "Convert";
        KEY_NAMES[KEY_NOCONVERT] = "No Convert";
        KEY_NAMES[KEY_YEN] = "Yen";
        KEY_NAMES[KEY_CIRCUMFLEX] = "Circumflex";
        KEY_NAMES[KEY_KANJI] = "Kanji";
        KEY_NAMES[KEY_AX] = "Ax";
        KEY_NAMES[KEY_UNLABELED] = "Unlabeled";
    }

    public static String getName(int keyId) {
        return KEY_NAMES[keyId];
    }
}
