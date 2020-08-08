package com.mf.warmtouch.model.dtos;

import lombok.Data;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

@Data
public class AboutMeDTO {
    private List<AboutMeElement> elements;

    public AboutMeDTO(List<AboutMeElement> elements) {
        this.elements = elements;
    }

    public AboutMeDTO(String textToConvert)
    {
        List<AboutMeElement> elements = new ArrayList<>();
        String currentType = "TEXT"; // TEXT / IMAGE
        StringBuilder text = new StringBuilder();

        for (int i=0; i<textToConvert.length(); i++)
        {
            char currentChar = textToConvert.charAt(i);

            if (currentChar == '{')
            {
                if (text.length() > 0)
                    elements.add(new AboutMeElement(text.toString(), currentType));
                text = new StringBuilder();
                currentType = "IMAGE";
            }
            else
            if (currentChar == '}')
            {
                if (text.length() > 0)
                    elements.add(new AboutMeElement(text.toString(), currentType));
                text = new StringBuilder();
                currentType = "TEXT";
            }
            else
            {
                text.append(currentChar);
                if (i == textToConvert.length()-1)
                {
                    if (text.length() > 0)
                        elements.add(new AboutMeElement(text.toString(), currentType));
                }
            }
        }

        this.elements = elements;
    }


}
