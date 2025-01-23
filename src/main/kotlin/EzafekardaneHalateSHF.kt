open class EzafekardaneHalateSHF(val dfa: Dfa) { // SHF = شرو و پایانه جدید است
    fun ezafeKardanHalateshorovaPayanJadid(): Dfa {
        val halateShoroJadid = "qs"
        val halatePayaneJadid = "qf"

        val entegaleJadid = dfa.entegalHa.toMutableMap()
        entegaleJadid[Pair(halateShoroJadid, "")] = dfa.stateshoro
        for (statePayann in dfa.statePayan) {
            entegaleJadid[Pair(statePayann, "")] = halatePayaneJadid
        }

        return Dfa(
            stateha = dfa.stateha + halateShoroJadid + halatePayaneJadid,
            nemadha = dfa.nemadha,
            entegalHa = entegaleJadid,
            stateshoro = halateShoroJadid,
            statePayan = setOf(halatePayaneJadid)
        )
    }
}