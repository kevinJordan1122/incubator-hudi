/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hudi.cli;

import org.apache.hudi.common.HoodieClientTestHarness;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.shell.Bootstrap;
import org.springframework.shell.core.JLineShellComponent;

/**
 * Class to start Bootstrap and JLineShellComponent.
 */
public abstract class AbstractShellIntegrationTest extends HoodieClientTestHarness {
  private static JLineShellComponent shell;

  @BeforeClass
  public static void startup() {
    Bootstrap bootstrap = new Bootstrap();
    shell = bootstrap.getJLineShellComponent();
  }

  @AfterClass
  public static void shutdown() {
    shell.stop();
  }

  @Before
  public void setup() throws Exception {
    initResources();
  }

  @After
  public void teardown() throws Exception {
    cleanupResources();
  }

  protected static JLineShellComponent getShell() {
    return shell;
  }
}
