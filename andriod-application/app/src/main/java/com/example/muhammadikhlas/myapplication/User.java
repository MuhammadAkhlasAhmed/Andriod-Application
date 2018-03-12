package com.example.muhammadikhlas.myapplication;

/**
 * Created by Muhammad IKHLAS on 9/24/2017.
 */
public class User {

        public String name;
        public String email;
        public String facebookID;
        public String gender;
   //   public AccessToken accessToken;

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getFacebookID() {
                return facebookID;
        }

        public void setFacebookID(String facebookID) {
                this.facebookID = facebookID;
        }

        public String getGender() {
                return gender;
        }

        public void setGender(String gender) {
                this.gender = gender;
        }
}
