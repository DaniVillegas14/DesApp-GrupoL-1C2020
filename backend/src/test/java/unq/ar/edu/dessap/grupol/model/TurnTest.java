package unq.ar.edu.dessap.grupol.model;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;

public class TurnTest {

    @Test
    public void testGivenATurnWithIdWhenReceiveGetIdThenGiveHisId() {
        Turn turn = Turn.builder()
                    .id(1).build();

        Assert.assertEquals(1, turn.getId());
    }

    @Test
    public void testGivenATurnWithStoreWhenReceiveGetStoreThenGiveHisStore() {

        Store storeMock = mock(Store.class);

        Turn turn = Turn.builder()
                    .store(storeMock).build();

        Assert.assertEquals(storeMock, turn.getStore());
    }

    @Test
    public void testGivenATurnWithUserWhenReceiveGetUserThenGiveHisUser() {

        User userMock = mock(User.class);

        Turn turn = Turn.builder()
                    .user(userMock).build();

        Assert.assertEquals(userMock, turn.getUser());
    }

    @Test
    public void testGivenATurnWithDateWhenReceiveGetLocalDateTimeThenGiveHisDate() {

        LocalDateTime date = LocalDateTime.now();

        Turn turn = Turn.builder()
                    .date(date).build();

        Assert.assertEquals(date, turn.getDate());
    }

    @Test
    public void testSetterTurn() {

        User userMock = mock(User.class);
        Store storeMock = mock(Store.class);
        LocalDateTime date = LocalDateTime.now();

        Turn turn = Turn.builder().build();
        turn.setId(1);
        turn.setUser(userMock);
        turn.setStore(storeMock);
        turn.setDate(date);

        Assert.assertEquals(1, turn.getId());
        Assert.assertEquals(userMock, turn.getUser());
        Assert.assertEquals(storeMock, turn.getStore());
        Assert.assertEquals(date, turn.getDate());
    }

    @Test
    public void testTurnEmptyBuilder() {
        Turn turn1 = Turn.builder().build();
        Turn turn2 = new Turn();

        Assert.assertNull(turn1.getDate());
        Assert.assertNull(turn1.getStore());
        Assert.assertNull(turn1.getUser());

        Assert.assertNull(turn2.getDate());
        Assert.assertNull(turn2.getStore());
        Assert.assertNull(turn2.getUser());
    }
}
