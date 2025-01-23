class HazfeHalateMorde(val dfa: Dfa) {

    fun hazfeHalatMorde():Dfa {
        val halatDastresi = mutableSetOf<String>()
        val entegalHayeJadid = mutableMapOf<Pair<String ,String> , String>()
        var KeyJadid: String? = null
        halatDastresi.add("qf")
        for ((key, value) in dfa.entegalHa) {
            if (value == "qf") {
                KeyJadid = key.first
                halatDastresi.add(KeyJadid)
            }
        }

        for ((key, value) in dfa.entegalHa.toList().asReversed()) {
            if (value == KeyJadid) {
                halatDastresi.add(key.first)
            }

        }

        for ((key, value) in dfa.entegalHa.toList().asReversed()) {

            if (halatDastresi.contains(value)) {
                halatDastresi.add(key.first)
            }
        }


        for ((key, value) in dfa.entegalHa) {

            if (halatDastresi.contains(value)) {
                entegalHayeJadid.set(key ,value)
            }

        }

        return Dfa(
            stateha = halatDastresi,
            nemadha = dfa.nemadha,
            entegalHa = entegalHayeJadid,
            stateshoro = dfa.stateshoro.takeIf { it in halatDastresi } ?: "",
            statePayan = dfa.statePayan.intersect(halatDastresi)
        )


    }
}