
## 실행하는 방법

Environment Variable에 다음을 넣고 실행 합니다.

```
DB_HOST=jdbc:mysql://<host>:3306/likelion-db;DB_USER=<username>;DB_PASSWORD=<password>
```

## Code

UserDaoTest.java

```java
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserDaoFactory.class)
class UserDaoTest {

    @Autowired
    ApplicationContext context;
    UserDao userDao;
    User user1;
    User user2;
    User user3;


    @BeforeEach
    void setUp() {
        this.userDao = context.getBean("awsUserDao", UserDao.class);
        this.user1 = new User("0", "kyeongrok", "12345");
        this.user2 = new User("1", "eternityHwan", "54321");
        this.user3 = new User("2", "jiyu", "abcde");
    }

    @Test
    void addAndGet() throws SQLException {
        userDao.deleteAll();
        assertEquals(0, userDao.getCount());
        userDao.add(user1);
        User user = userDao.findById(user1.getId());
        assertEquals(user1.getName(), user.getName());
        assertEquals(user1.getPassword(), user.getPassword());
    }

    @Test
    @DisplayName("findById에서 해당 user를 못 찾은 경우 Exception이 잘 발생 하는지")
    void emptyResultException() throws SQLException {
        userDao.deleteAll();
        assertThrows(EmptyResultDataAccessException.class, () -> userDao.findById("0"));
    }

    @Test
    @DisplayName("findAll이 잘 작동 하는지")
    void findAll() {
        userDao.deleteAll();
        assertEquals(0, userDao.findAll().size());
        userDao.add(user1);
        userDao.add(user2);
        userDao.add(user3);
        assertEquals(3, userDao.findAll().size());

    }
}
```

UserDaoFactory.java

```java
@Configuration
public class UserDaoFactory {

    @Bean
    public UserDao awsUserDao() {
        return new UserDao(awsDataSource());
    }

    public DataSource awsDataSource() {
        Map<String, String> env = System.getenv();
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
        dataSource.setUrl(env.get("DB_HOST"));
        dataSource.setUsername(env.get("DB_USER"));
        dataSource.setPassword(env.get("DB_PASSWORD"));
        return dataSource;
    }
}
```

UserDao.java

```java
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    RowMapper<User> rowMapper = (rs, rowNum) ->  new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));

    public void deleteAll() {
        this.jdbcTemplate.update("delete from users");
    }

    public int getCount() {
        return this.jdbcTemplate.queryForObject("select count(*) from users", Integer.class);
    }

    public void add(User user) {
        this.jdbcTemplate.update("INSERT INTO users(id, name, password) VALUES(?,?,?);",
                user.getId(), user.getName(), user.getPassword());
    }

    public User findById(String id) {
        return this.jdbcTemplate.queryForObject("select * from users where id = ?",
                rowMapper, id);
    }

    public List<User> findAll() {
        return this.jdbcTemplate.query("select * from users",
                rowMapper);
    }

}
```

