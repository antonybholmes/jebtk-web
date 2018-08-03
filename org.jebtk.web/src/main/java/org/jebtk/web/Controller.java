package org.jebtk.web;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.jebtk.core.text.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class Controller {
  public static final Pattern WORD_GROUP_REGEX = Pattern.compile("([a-zA-Z0-9\\-\\ ]+)");
  
  @Autowired
  protected ServletContext mContext;

  @Autowired
  protected HttpServletRequest mRequest;
  
  /**
   * Attempts to find a string of only letters, numbers, spaces and dashes
   * within a string.
   * 
   * @param s
   * @return
   */
  public static String santizeWords(String s) {
    Matcher matcher = WORD_GROUP_REGEX.matcher(s);
    
    if (matcher.find()) {
      return matcher.group(1);
    } else {
      return TextUtils.EMPTY_STRING;
    }
    
  }
}
