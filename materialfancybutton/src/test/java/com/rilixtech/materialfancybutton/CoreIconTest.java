/*
 * Copyright (C) 2020-21 Application Library Engineering Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rilixtech.materialfancybutton;

import com.rilixtech.materialfancybutton.typeface.IIcon;
import com.rilixtech.materialfancybutton.typeface.ITypeface;
import ohos.agp.text.Font;
import ohos.app.AbilityContext;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import static org.junit.Assert.*;

public class CoreIconTest {

    @Before
    public void configureLogger() {
        CoreIcon.setLoggingEnabled(false);
    }

    @Test
    public void testInit() {
        CoreIcon.init();
        assertTrue(CoreIcon.isInitDone());
    }

    @Test
    public void testIconExists() {
        assertFalse(CoreIcon.iconExists("testCoreIconFindFontKey"));
    }

    @Test
    public void testRegisterFont() {
        ITypeface iTypeface = new ITypeface() {
            @Override
            public IIcon getIcon(String key) {
                return null;
            }

            @Override
            public HashMap<String, Character> getCharacters() {
                return null;
            }

            @Override
            public String getMappingPrefix() {
                return null;
            }

            @Override
            public String getFontName() {
                return null;
            }

            @Override
            public String getVersion() {
                return null;
            }

            @Override
            public int getIconCount() {
                return 0;
            }

            @Override
            public Collection<String> getIcons() {
                return new ArrayList<>();
            }

            @Override
            public String getAuthor() {
                return null;
            }

            @Override
            public String getUrl() {
                return null;
            }

            @Override
            public String getDescription() {
                return null;
            }

            @Override
            public String getLicense() {
                return null;
            }

            @Override
            public String getLicenseUrl() {
                return null;
            }

            @Override
            public Font getTypeface(AbilityContext ctx) {
                return null;
            }
        };
        assertFalse(CoreIcon.registerFont(iTypeface));
    }

    @Test
    public void testGetRegisteredFonts() {
        assertNotNull(CoreIcon.getRegisteredFonts());
    }

    @Test
    public void testFindFont() {
        assertNull(CoreIcon.findFont("testCoreIconFindFontKey"));
    }

    @Test
    public void testFindFont2() {
        IIcon iIcon = new IIcon() {
            @Override
            public String getFormattedName() {
                return null;
            }

            @Override
            public String getName() {
                return null;
            }

            @Override
            public char getCharacter() {
                return 0;
            }

            @Override
            public ITypeface getTypeface() {
                return null;
            }
        };
        assertNull(CoreIcon.findFont(iIcon));
    }

    @Test
    public void testIsLoggingEnabled() {
        CoreIcon.setLoggingEnabled(false);
        assertFalse(CoreIcon.isLoggingEnabled());
    }
}