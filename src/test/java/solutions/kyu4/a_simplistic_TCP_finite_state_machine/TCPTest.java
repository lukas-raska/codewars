package solutions.kyu4.a_simplistic_TCP_finite_state_machine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TCPTest {
    @Test
    public void SampleTests() {
        assertEquals("CLOSE_WAIT",   TCP.traverseStates(new String[] {"APP_ACTIVE_OPEN","RCV_SYN_ACK","RCV_FIN"}));
        assertEquals("ESTABLISHED",  TCP.traverseStates(new String[] {"APP_PASSIVE_OPEN", "RCV_SYN","RCV_ACK"}));
        assertEquals("LAST_ACK",     TCP.traverseStates(new String[] {"APP_ACTIVE_OPEN","RCV_SYN_ACK","RCV_FIN","APP_CLOSE"}));
        assertEquals("SYN_SENT",     TCP.traverseStates(new String[] {"APP_ACTIVE_OPEN"}));
        assertEquals("ERROR",        TCP.traverseStates(new String[] {"APP_PASSIVE_OPEN","RCV_SYN","RCV_ACK","APP_CLOSE","APP_SEND"}));
    }
}