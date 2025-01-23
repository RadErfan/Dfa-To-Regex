
fun main() { val stateha = setOf("q3" )
    val nemadha = setOf("a")
    val entegalHa = mapOf(
        Pair("q3", "a") to "q3",

    )
    val stateshoro = "q3"
    val statePayan = setOf("q3")

    val dfa = Dfa(stateha, nemadha, entegalHa, stateshoro, statePayan)

    // inja ba estefade az classe PazireshDfa()  barasi mikonim ke aya dfa dade shode motabar hastesh ya na
    val paziresh = PazireshDfa(dfa)
    if (paziresh.isDFA()) {
        println("DFA motabar ast.")

        // inja ba estefade az classe EzafekardaneHalateSHF() halate shoro va payan jadid ro ezafe mikonim
        val ezafekardaneHalate = EzafekardaneHalateSHF(dfa)
        val dfaJadid = ezafekardaneHalate.ezafeKardanHalateshorovaPayanJadid()

        // inja ba estefade az classe HazfeHalateMIani() halate miani ro hazf mikonim
        val dfaEslahShode = HazfeHalateMorde(dfaJadid).hazfeHalatMorde()
        val listEntegalHa: MutableList<Dfaa> = mutableListOf()

        dfaEslahShode.entegalHa.forEach {
            val keyFirst = it.key.first
            val keySecond = it.key.second
            val value = it.value

            val dfaa = Dfaa(
                keyFirst , value , keySecond
            )
            listEntegalHa.add(dfaa)
        }




        val regex = dfabeebaratemonazam( listEntegalHa)
        println("ebarateMonazam: $regex")

    } else {
        println("DFA motabar nist.")
    }
}