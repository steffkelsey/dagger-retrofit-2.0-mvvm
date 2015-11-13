package com.thecodeviking.daggerretrofitmvvm.models;

import java.util.ArrayList;
import java.util.List;

public class UserSearchResult {
    private int total_count;
    private boolean incomplete_results;
    private List<GitHubUser> items = new ArrayList<>();

    public int getTotalCount() {
        return total_count;
    }

    public void setTotalCount(int totalCount) {
        this.total_count = totalCount;
    }

    public boolean isIncompleteResults() {
        return incomplete_results;
    }

    public void setIncompleteResults(boolean incompleteResults) {
        this.incomplete_results = incompleteResults;
    }

    public List<GitHubUser> getItems() {
        return items;
    }

    public void setItems(List<GitHubUser> items) {
        this.items = items;
    }
}
