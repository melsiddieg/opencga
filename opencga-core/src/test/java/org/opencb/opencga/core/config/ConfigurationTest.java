/*
 * Copyright 2015 OpenCB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.opencb.opencga.core.config;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by imedina on 25/04/16.
 */
public class ConfigurationTest {

    @Test
    public void testDefault() {
        Configuration configuration = new Configuration();

        configuration.setServer(new ServerConfiguration(8081, 8082));

        try {
            configuration.serialize(new FileOutputStream("/tmp/configuration-test.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}