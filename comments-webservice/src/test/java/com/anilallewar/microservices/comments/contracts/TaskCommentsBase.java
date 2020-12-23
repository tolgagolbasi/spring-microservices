package com.anilallewar.microservices.comments.contracts;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import com.anilallewar.microservices.comments.CommentsApplication;

/**
 * Base class for the generated contract provider tests<br>
 * <br>
 *
 * The name of the class if defined by 2 things
 * <ol>
 * <li>Sub-folder under the <b>contractsDir</b> while defaults to
 * <code>/src/test/resources/contracts</code></li>
 * <li><code>packageWithBaseClasses</code> defined in build.gradle</li>
 * <li>Since the package for base classes is defined as
 * <code>com.anilallewar.microservices.comments.contracts</code> and the
 * contract is defined under the <i>task/comments</i> folder under
 * <b>test/resources/contracts</b>, the base class name is TaskCommentsBase</li>
 * </ol>
 *
 * @author anilallewar
 *
 */
@Disabled
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = { CommentsApplication.class }, webEnvironment = WebEnvironment.MOCK, properties = {
		"spring.cloud.discovery.enabled=false", "spring.cloud.config.enabled=false" })
public abstract class TaskCommentsBase {

	@Autowired
	private WebApplicationContext context;

	@BeforeAll
	public void setUp() throws Exception {
		RestAssuredMockMvc.webAppContextSetup(context);
	}

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * Return the formatted date for validation
	 *
	 * @param timeValue
	 * @return
	 */
	public String convertTimeValueToDate(Long timeValue) {
		return dateFormat.format(new Date(timeValue));
	}
}
