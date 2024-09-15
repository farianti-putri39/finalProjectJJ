# FINAL PROJECT
Berikut merupakan hasil testing yang telah saya buat

Jenis automation test yang dilakukan :
1. API Test https://gorest.co.in/public/v2/
2. Web Automation Test https://www.demoblaze.com/


Berikut merupakan dependencies yang saya gunakan :

    testImplementation platform('org.junit:junit-bom:5.9.1')
    testImplementation 'org.junit.jupiter:junit-jupiter'
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.1'
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.8.1'
    testImplementation 'org.junit.vintage:junit-vintage-engine:5.7.2'
    implementation group: 'io.cucumber', name: 'cucumber-java', version: '7.12.0'
    testImplementation group: 'io.cucumber', name: 'cucumber-junit', version: '7.12.0'
    testImplementation group: 'io.rest-assured', name: 'rest-assured', version: '5.3.0'
    testImplementation group: 'org.json', name: 'json', version: '20220924'
    testImplementation 'io.rest-assured:json-path:5.3.0'
    testImplementation 'io.rest-assured:json-schema-validator:5.3.0'
    testImplementation group: 'org.assertj', name: 'assertj-core', version: '3.24.0'
    implementation group: 'org.seleniumhq.selenium', name: 'selenium-java', version: '4.17.0'
    testImplementation ("io.github.bonigarcia:webdrivermanager:5.6.3")


Scenario API test (@api):

1. Get list data
2. Create new user
3. Delete user
4. Update user
5. Get user details
6. Get user posts
7. Post user posts
8. Get user todo
9. Post user todo
10. Get user comment
11. Post user comment


Scenario Web test (@web):

1. Test Login Web
2. Test Login Web Standard User Invalid Password
3. Test Login Web Non-existent User
4. Test Sign Up Valid User
5. Test Sign Up Existing User
6. Test Send Contact Message
7. Test Open About Popup
8. Test Open Cart Page
9. Test Create Order

How to Run API Test:
./gradlew apiTest

How to Run Web Test:
./gradlew webTest
