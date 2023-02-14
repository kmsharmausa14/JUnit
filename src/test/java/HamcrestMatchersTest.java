import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class HamcrestMatchersTest {
  @Test
  public void test(){
    List<Integer> list = Arrays.asList(1,2,3,4);
    assertThat(list,hasSize(4));
    assertThat(list,hasItems(1,2,9));
    assertThat(list, everyItem(greaterThan(3)));
    assertThat(list, everyItem(lessThan(3)));

    assertThat("", isEmptyString());
    assertThat(null, isEmptyOrNullString());

    Integer[] marks = {1,2,3};
    assertThat(marks, arrayWithSize(3));
    assertThat(marks,arrayContaining(1,2,3));
    assertThat(marks, arrayContainingInAnyOrder(1,3,2));
  }
}
