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

package org.opencb.opencga.storage.variant;

import org.opencb.opencga.storage.core.variant.adaptors.VariantDBAdaptor;
import org.opencb.opencga.storage.variant.sqlite.VariantSqliteDBAdaptor;
import org.junit.*;
import org.opencb.commons.containers.QueryResult;
import org.opencb.commons.containers.map.QueryOptions;
import org.opencb.commons.test.GenericTest;
import org.opencb.opencga.core.auth.IllegalOpenCGACredentialsException;
import org.opencb.opencga.core.auth.SqliteCredentials;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Arrays;
import org.opencb.biodata.models.feature.Region;
import org.opencb.biodata.models.variant.VariantSource;

/**
 * @author Alejandro Aleman Ramos <aaleman@cipf.es>
 */
public class VariantSqliteQueryBuilderTest extends GenericTest {

    //    private static String inputFile = VariantSqliteQueryBuilderTest.class.getResource("/variant-test-file.vcf.gz").getFile();
    private static String inputFile = "/tmp/file.vcf";
    private static String pedFile = VariantSqliteQueryBuilderTest.class.getResource("/pedigree-test-file.ped").getFile();
    private static String outputFile = "/tmp/sqliteIndexTest.db";
    private static VariantSource study = new VariantSource("study1", "s1", "Study 1", Arrays.asList("Alejandro", "Cristina"), Arrays.asList(inputFile, pedFile));

    @BeforeClass
    public static void createDB() throws IOException, IllegalOpenCGACredentialsException {
//        FileUtils.delete(new File(outputFile));
//        System.out.println("Creating DB");
//        System.out.println("inputFile = " + inputFile);
//        System.out.println("outputFile = " + outputFile);
//        VariantDataReader reader = new VariantVcfDataReader(inputFile);
//        VariantDBWriter writer = new VariantVcfSqliteWriter(new SqliteCredentials(Paths.get(outputFile)));
//        VariantRunner stats = new VariantStatsRunner(study, reader, null, writer);
//        VariantRunner effect = new VariantEffectRunner(study, reader, null, writer, stats);
//        VariantRunner runner = new VariantIndexRunner(study, reader, null, writer, effect);
//        runner.run();
    }

    @AfterClass
    public static void deleteDB() {

//        FileUtils.delete(new File(outputFile));

    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getAllVariantsByRegion() throws IllegalOpenCGACredentialsException, SQLException, ClassNotFoundException {

        System.out.println(" - " + outputFile);

        Region r = new Region("1", 1, 200000000);

        QueryOptions qo = new QueryOptions();
        qo.put("stats", false);
        qo.put("effect", false);

        SqliteCredentials sc = new SqliteCredentials(Paths.get(outputFile));
        VariantDBAdaptor vqb = new VariantSqliteDBAdaptor(sc);

        QueryResult qr = vqb.getAllVariantsByRegionAndStudy(r, "", qo);
        System.out.println(qr);


    }
}
