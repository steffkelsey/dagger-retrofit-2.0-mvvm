package com.thecodeviking.daggerretrofitmvvm.models;

public class GitHubUser {
    private String login;
    private int id;
    private String avatar_url;
    private String gravatar_id;
    private String url;
    private String html_url;
    private String followers_url;
    private String following_url;
    private String gists_url;
    private String starred_url;
    private String subscriptions_url;
    private String organizations_url;
    private String repos_url;
    private String events_url;
    private String received_events_url;
    private String type;
    private boolean site_admin;
    private float score;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatarUrl() {
        return avatar_url;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatar_url = avatarUrl;
    }

    public String getGravatarId() {
        return gravatar_id;
    }

    public void setGravatarId(String gravatarId) {
        this.gravatar_id = gravatarId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtmlUrl() {
        return html_url;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.html_url = htmlUrl;
    }

    public String getFollowersUrl() {
        return followers_url;
    }

    public void setFollowersUrl(String followersUrl) {
        this.followers_url = followersUrl;
    }

    public String getFollowingUrl() {
        return following_url;
    }

    public void setFollowingUrl(String followingUrl) {
        this.following_url = followingUrl;
    }

    public String getGistsUrl() {
        return gists_url;
    }

    public void setGistsUrl(String gistsUrl) {
        this.gists_url = gistsUrl;
    }

    public String getStarredUrl() {
        return starred_url;
    }

    public void setStarredUrl(String starredUrl) {
        this.starred_url = starredUrl;
    }

    public String getSubscriptionsUrl() {
        return subscriptions_url;
    }

    public void setSubscriptionsUrl(String subscriptionsUrl) {
        this.subscriptions_url = subscriptionsUrl;
    }

    public String getOrganizationsUrl() {
        return organizations_url;
    }

    public void setOrganizationsUrl(String organizationsUrl) {
        this.organizations_url = organizationsUrl;
    }

    public String getReposUrl() {
        return repos_url;
    }

    public void setReposUrl(String reposUrl) {
        this.repos_url = reposUrl;
    }

    public String getEventsUrl() {
        return events_url;
    }

    public void setEventsUrl(String eventsUrl) {
        this.events_url = eventsUrl;
    }

    public String getReceivedEventsUrl() {
        return received_events_url;
    }

    public void setReceivedEventsUrl(String receivedEventsUrl) {
        this.received_events_url = receivedEventsUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isSiteAdmin() {
        return site_admin;
    }

    public void setSiteAdmin(boolean siteAdmin) {
        this.site_admin = siteAdmin;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
