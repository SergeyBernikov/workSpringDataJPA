package ru.bsa.models;

import lombok.*;
import ru.bsa.patternPrototype.Copyable;
import javax.persistence.*;
@AllArgsConstructor                                         // создать конструктор со всеми полями
@NoArgsConstructor                                          // создать пустой конструктор
@Builder                                                    // объект-строитель
@Getter                                                     // создать геттеры
@Setter                                                     // создать сеттеры
@ToString                                                   // реализация метода toString()

@Entity
// @Entity - указывает, что данный бин (класс) является сущностью (класс будет содержать таблицу)
public class Human implements Copyable {
    @Id                                                     // @Id — id колонки
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // стратегия IDENTITY позволяет надежно получать уникальные ID вне зависимости от клиентов, использующих БД
    @Column(name = "id")
    private Long id;                                        // уникальный id
    @Column(name = "name")
    private String name;                                    // имя
    @Column(name = "email")
    private String email;                                   // email

    @Override
    public Object clone() {
        Human human = new Human(id, name, email);
        return human;
    }
}
