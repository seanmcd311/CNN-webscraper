package com.cnn;


import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Scanner; 

public class webscrap {

    public static void main(String[] args){

        Scanner myObj = new Scanner(System.in); 
        System.out.println("Enter CNN URL: ");
        String URL = myObj.nextLine();
        myObj.close();
        try{

    

             Document doc = Jsoup.connect(URL).userAgent("mozilla/17.0").get();
             Elements Temp = doc.select("title");

            Elements body = doc.select("div.zn-body__paragraph");
            Elements author = doc.select("div.metadata");

            item data = new item();



            for(Element titl:Temp){

                data.SetHeadline(titl.getElementsByTag("title").first().text());
                break;
            }
         String temp2 = ""; 
         
         
         for(Element BOD:body){

            temp2 = temp2 + BOD.getElementsByTag("div").first().text();
          }

          data.SetBody(temp2);

          for(Element aut:author){

            data.SetAuthor(aut.getElementsByTag("a").first().text());
  
          }
          
          System.out.println(data.GetHeadline());
          System.out.println(data.GetAuthor());
          System.out.println(data.GetBody());
        }

        catch(IOException e) {

            e.printStackTrace();

        }
    }
    



}