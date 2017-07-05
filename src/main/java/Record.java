import java.util.*;
import java.time.LocalDateTime;

public class Record {
  private String mArtist;
  private String mAlbum;
  private LocalDateTime mCreatedAt;
  private static List<Record> instances = new ArrayList<Record>();
  private int mId;

  public Record(String artist, String album){
    mArtist = artist;
    mAlbum = album;
    mCreatedAt = LocalDateTime.now();
    instances.add(this);
    mId = instances.size();
  }

  public String getArtist(){
    return mArtist;
  }

  public String getAlbum(){
    return mAlbum;
  }

  public LocalDateTime getCreatedAt(){
    return mCreatedAt;
  }

  public static void clear(){
    instances.clear();
  }

  public static List<Record> all(){
    return instances;
  }

  public int getId(){
    return mId;
  }

}
