package testApi;

import lombok.Data;


public class User {
    /*
        "id": 1,
        "name": "Leanne Graham",
        "username": "Bret",
        "email": "Sincere@april.biz",
        "address": {
          "street": "Kulas Light",
          "suite": "Apt. 556",
          "city": "Gwenborough",
          "zipcode": "92998-3874",
          "geo": {
            "lat": "-37.3159",
            "lng": "81.1496"
          }
        },
        "phone": "1-770-736-8031 x56442",
        "website": "hildegard.org",
        "company": {
          "name": "Romaguera-Crona",
          "catchPhrase": "Multi-layered client-server neural-net",
          "bs": "harness real-time e-markets"
        }
     */
    int id;
    private String name;
    private String userName;
    private String email;
    private Adress adress;
    private String phone;
    private String website;
    private Company company;


    public static class Adress {
        String street;
        String suite;
        String city;
        String zipcode;
        Geo geo;


        public static class Geo {
            String lat;
            String lng;

            public static class Builder {
                private Geo geo;

                public Builder() {
                    geo = new Geo();
                }

                public Builder setLat(String lat) {
                    geo.lat = lat;
                    return this;
                }

                public Builder setLng(String lng) {
                    geo.lng = lng;
                    return this;
                }

                public Geo build() {
                    return geo;
                }
            }
        }

        public static class Builder {
            private Adress adress;

            public Builder() {
                adress = new Adress();
            }

            public Builder setStreet(String street) {
                adress.street = street;
                return this;
            }

            public Builder setSuite(String suite) {
                adress.suite = suite;
                return this;
            }

            public Builder setCity(String city) {
                adress.city = city;
                return this;
            }

            public Builder setZipCode(String zipcode) {
                adress.zipcode = zipcode;
                return this;
            }

            public Builder setGeo(Geo geo) {
                adress.geo = geo;
                return this;
            }

            public Adress build() {
                return adress;
            }
        }
    }


    public static class Company {
        String name;
        String catchPhrase;
        String bs;

        public static class Builder {
            private Company company;

            public Builder() {
                company = new Company();
            }

            public Builder setName(String name) {
                company.name = name;
                return this;
            }

            public Builder setCatchPhrase(String catchPhrase) {
                company.catchPhrase = catchPhrase;
                return this;
            }

            public Builder setBs(String bs) {
                company.bs = bs;
                return this;
            }

            public Company build() {
                return company;
            }

        }
    }


    public User createUser() {
        User testUser = new User.Builder()
                .setName("Leanne Mor")
                .setUserName("Byba")
                .setEmail("MA@gmail.com")
                .setPhone("1-770-736-8031 x56442")
                .setAdress(new User.Adress.Builder().setCity("Starcon").setStreet("MyStreet").setSuite("MySuit").setZipCode("31100").setGeo(new User.Adress.Geo.Builder().setLat("12121212").setLng("4564645").build()).build())
                .setCompany(new User.Company.Builder().setName("GU").setBs("BS").setCatchPhrase("Phase").build())
                .build();

        return testUser;
    }


    public static class Builder {
        private User newUser;

        public Builder() {
            newUser = new User();
        }

        public Builder setName(String name) {
            newUser.name = name;
            return this;
        }

        public Builder setUserName(String userName) {
            newUser.userName = userName;
            return this;
        }

        public Builder setEmail(String email) {
            newUser.email = email;
            return this;
        }

        public Builder setAdress(Adress adress) {
            newUser.adress = adress;
            return this;
        }

        public Builder setPhone(String phone) {
            newUser.phone = phone;
            return this;
        }

        public Builder setWebsite(String website) {
            newUser.website = website;
            return this;
        }

        public Builder setCompany(Company company) {
            newUser.company = company;
            return this;
        }


        public User build() {
            return newUser;
        }
    }
}