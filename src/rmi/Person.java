package rmi;import java.io.Serializable;class Person implements Serializable {    private static final long serialVersionUID = 8234198669757615847L;    private Integer id;    private String name;    private Integer age;    Person() {    }    public Person(Integer id, String name, Integer age) {        this.id = id;        this.name = name;        this.age = age;    }    public Integer getId() {        return id;    }    void setId(Integer id) {        this.id = id;    }    String getName() {        return name;    }    void setName(String name) {        this.name = name;    }    public Integer getAge() {        return age;    }    public void setAge(int age) {        this.age = age;    }    @Override    public String toString() {        return "Person{" +                "id=" + id +                ", name='" + name + '\'' +                ", age='" + age + '\'' +                '}';    }}