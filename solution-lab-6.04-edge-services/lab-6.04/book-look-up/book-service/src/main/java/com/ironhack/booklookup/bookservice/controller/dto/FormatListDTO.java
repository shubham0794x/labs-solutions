package com.ironhack.booklookup.bookservice.controller.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class FormatListDTO {
    @NotNull(message = "The format list can't be null.")
    @NotEmpty(message = "The format list can't be empty.")
    private List<String> formatList;

    public List<String> getFormatList() {
        return formatList;
    }

    public void setFormatList(List<String> formatList) {
        this.formatList = formatList;
    }
}
