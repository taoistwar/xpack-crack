package org.elasticsearch.xpack.core;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;

import org.elasticsearch.core.PathUtils;
import org.elasticsearch.core.SuppressForbidden;

public class XPackBuild {
  public static final XPackBuild CURRENT;
  private String shortHash;
  private String date;

  @SuppressForbidden(reason = "looks up path of xpack.jar directly")
  static Path getElasticsearchCodebase() {
    final URL location = XPackBuild.class.getProtectionDomain().getCodeSource().getLocation();
    try {
      return PathUtils.get(location.toURI());
    } catch (URISyntaxException ex) {
      throw new RuntimeException(ex);
    }
  }

  XPackBuild(final String shortHash, final String date) {
    this.shortHash = shortHash;
    this.date = date;
  }

  public String shortHash() {
    return this.shortHash;
  }

  public String date() {
    return this.date;
  }

  static {
    getElasticsearchCodebase();
    CURRENT = new XPackBuild("Unknown", "Unknown");
  }
}