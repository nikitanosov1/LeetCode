package problem_1061;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void smallestEquivalentString_1() {
        String s1 = "parker";
        String s2 = "morris";
        String baseStr = "parser";
        String output = "makkek";
        assertEquals(output, new Solution().smallestEquivalentString(s1, s2, baseStr));
    }

    @Test
    void smallestEquivalentString_2() {
        String s1 = "hello";
        String s2 = "world";
        String baseStr = "hold";
        String output = "hdld";
        assertEquals(output, new Solution().smallestEquivalentString(s1, s2, baseStr));
    }

    @Test
    void smallestEquivalentString_3() {
        String s1 = "leetcode";
        String s2 = "programs";
        String baseStr = "sourcecode";
        String output = "aauaaaaada";
        assertEquals(output, new Solution().smallestEquivalentString(s1, s2, baseStr));
    }

    @Test
    void smallestEquivalentString_4() {
        String s1 = "ceihfgechfcbjhadaibhghcbdhfaecdaijigaaafcadebciabb";
        String s2 = "gafbfceidigjceeigcddichdhhbgibjbaagbfciiecjaiajahh";
        String baseStr = "eoiloytuagirigmbarebhzgveiavyruxlrxzbommyfjjngfktd";
        String output = "aoaloytuaaaraamaaraaazavaaavyruxlrxzaommyaaanaakta";
        assertEquals(output, new Solution().smallestEquivalentString(s1, s2, baseStr));
    }

    @Test
    void smallestEquivalentString_5() {
        String s1 = "opecenadojbodihfgmpijpfocomhcncicefpohkibjckijghii";
        String s2 = "ndlbhpaeppgekfhnjnmmplmdoifdhbglmedpjgleofgnahglbe";
        String baseStr = "ttusuhhrabgsswpaapxoxdanchyccmpjitwwmfioedtbiggfru";
        String output = "ttusuaaraaasswaaaaxaxaaaaayaaaaaatwwaaaaaataaaaaru";
        assertEquals(output, new Solution().smallestEquivalentString(s1, s2, baseStr));
    }
}