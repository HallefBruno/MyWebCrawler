package com.org.mywebcrawler.exec;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import javax.swing.JOptionPane;

public class ExectRuntime<T> implements IExecRuntime<T> {
  @Override
  public T httpProcess(Class o, String url) {
    try {
      Process process = Runtime.getRuntime().exec(url);
      try ( BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream(), Charset.forName("UTF-8")))) {
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
          content.append(inputLine);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return (T) objectMapper.readValue(content.toString(), o);
      }
    } catch (IOException ex) {
      JOptionPane.showMessageDialog(null, "Um erro ocorreu ao realizar a busca!");
    }
    return null;
  }
}
