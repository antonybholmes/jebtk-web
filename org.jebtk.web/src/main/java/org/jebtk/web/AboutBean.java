package org.jebtk.web;

import org.jebtk.core.AppInfo;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "name", "version", "copyright" })
public class AboutBean {

  private AppInfo mInfo;

  public AboutBean(AppInfo info) {
    mInfo = info;
  }
  
  @JsonGetter("name")
  public String getName() {
    return mInfo.getName();
  }

  @JsonGetter("version")
  public String getVersion() {
    return mInfo.getVersion().toString();
  }

  @JsonGetter("copyright")
  public String getCopyright() {
    return mInfo.getCopyright();
  }
}
