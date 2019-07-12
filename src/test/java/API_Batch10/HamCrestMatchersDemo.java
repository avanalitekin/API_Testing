package API_Batch10;

import org.testng.annotations.Test;

import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.*;

import org.hamcrest.MatcherAssert;
import static org.hamcrest.MatcherAssert.*;


import java.util.Arrays;
import java.util.List;



public class HamCrestMatchersDemo {
	
	
  @Test
  public void test() {
	  MatcherAssert.assertThat(1,Matchers.equalTo(1));
	  String str1="Programmer";
	  String str2="Programmer";
	  MatcherAssert.assertThat(str1, Matchers.is(str2));
	  MatcherAssert.assertThat(str1, Matchers.is("Programmer"));
	  MatcherAssert.assertThat(str1, Matchers.is(Matchers.not("engineer")));
	  MatcherAssert.assertThat(str1, Matchers.equalToIgnoringCase("programmer"));
	  MatcherAssert.assertThat(str1, Matchers.equalToIgnoringWhiteSpace("  programmeR "));
	  MatcherAssert.assertThat(10, Matchers.greaterThan(9));
	  MatcherAssert.assertThat(10, Matchers.lessThan(11));
	  MatcherAssert.assertThat(10, Matchers.lessThanOrEqualTo(11));
	  MatcherAssert.assertThat(str1, Matchers.notNullValue());
	  
	  List<String> list=Arrays.asList("one", "two", "three");
	  MatcherAssert.assertThat(list, Matchers.hasSize(3));
	  MatcherAssert.assertThat(list, Matchers.containsInAnyOrder("three","one","two"));
	  MatcherAssert.assertThat(list, Matchers.hasItems("one","three"));
	  
	  List<Integer> numbers=Arrays.asList(11,12,13);
	  MatcherAssert.assertThat(numbers, Matchers.everyItem(Matchers.greaterThan(10)));	  
	  
	  
  }
}
