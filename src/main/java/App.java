import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.*;

public class App {

  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/collection", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/collection.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/collection", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String artist = request.queryParams("artist");
      String album = request.queryParams("album");
      Record newRecord = new Record(artist, album);
      model.put("allRecords", Record.all());
      model.put("artist", newRecord.getArtist());
      model.put("album", newRecord.getAlbum());
      model.put("template", "templates/collection.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
