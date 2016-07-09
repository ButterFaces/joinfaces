/*
 * Copyright 2016-2016 the original author or authors.
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

package com.github.persapiens.jsfboot.mock;

import javax.inject.Inject;

import lombok.Getter;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.springframework.context.ApplicationContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * Abstract integration test for jsf Activate JsfMock for each test execution
 */
public class JsfIT extends AbstractTestNGSpringContextTests {

	@Getter
	private JsfMock jsfMock;

	@Inject
	private ApplicationContext applicationContext;

	@BeforeMethod
	public void init() {
		this.jsfMock = new JsfMock();
		this.jsfMock.init(this.applicationContext);
	}

	@AfterMethod
	public void release() {
		this.jsfMock.release();
	}

}
