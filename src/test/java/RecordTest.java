import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class RecordTest {

  @Test
  public void Record_instantiatesCorrectly_true(){
    Record testRecord = new Record("Deafheaven", "New Bermuda");
    assertEquals(true, testRecord instanceof Record);
  }


  @Test
  public void Record_instanstiatesWithArtistAndAlbum_String(){
    Record testRecord = new Record("Deafheaven", "New Bermuda");
    assertEquals("Deafheaven", testRecord.getArtist());
    assertEquals("New Bermuda", testRecord.getAlbum());
  }

  @Test
  public void getCreatedAt_instantiatesWithCurrentTime_today(){
    Record testRecord = new Record("Deafheaven", "New Bermuda");
    assertEquals(LocalDateTime.now().getDayOfWeek(), testRecord.getCreatedAt().getDayOfWeek());
  }

  @Test
  public void all_returnsAllInstancesOfRecord_true() {
    Record firstRecord = new Record("Deafheaven", "New Bermuda");
    Record secondRecord = new Record("Beach House", "Master of None");
    assertEquals(true, Record.all().contains(firstRecord));
    assertEquals(true, Record.all().contains(secondRecord));
  }

  @Test
  public void clear_emptiesAllRecordsFromArrayList_0() {
    Record myRecord = new Record("Deafheaven", "New Bermuda");
    Record.clear();
    assertEquals(Record.all().size(), 0);
  }

  @Test
  public void getId_recordsInstantiateWithAnID_1() {
    Record.clear();
    Record myRecord = new Record("Deafheaven", "New Bermuda");
    assertEquals(1, myRecord.getId());
  }
}
