package com.searchms.genericsearchms.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchObject
{
    @JsonProperty("searchField")
    private String searchField;
    @JsonProperty("searchValue")
    private String searchValue;

    public String getSearchField() {
        return searchField;
    }

    public void setSearchField(String searchField) {
        this.searchField = searchField;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }
}
