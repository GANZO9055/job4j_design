package ru.job4j.generics;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class RoleStoreTest {
    @Test
    void whenAddAndFindThenRoleProgrammer() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Programmer"));
        Role result = store.findById("1");
        assertThat(result.getRole()).isEqualTo("Programmer");
    }

    @Test
    void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Programmer"));
        Role result = store.findById("10");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindRoleProgrammer() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Programmer"));
        store.add(new Role("1", "DevOps"));
        Role result = store.findById("1");
        assertThat(result.getRole()).isEqualTo("Programmer");
    }

    @Test
    void whenReplaceThenRoleWithDevOps() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Programmer"));
        store.replace("1", new Role("1", "DevOps"));
        Role result = store.findById("1");
        assertThat(result.getRole()).isEqualTo("DevOps");
    }

    @Test
    void whenReplaceRoleImpossible() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Programmer"));
        store.replace("10", new Role("10", "DevOps"));
        Role result = store.findById("1");
        assertThat(result.getRole()).isEqualTo("Programmer");
    }

    @Test
    void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Programmer"));
        store.delete("1");
        Role result = store.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteRoleThenRoleIsProgrammer() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Programmer"));
        store.delete("10");
        Role result = store.findById("1");
        assertThat(result.getRole()).isEqualTo("Programmer");
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Programmer"));
        boolean result = store.replace("1", new Role("1", "DevOps"));
        assertThat(result).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Programmer"));
        boolean result = store.replace("10", new Role("10", "DevOps"));
        assertThat(result).isFalse();
    }
}