
fun ezafeKardaneEntegalaha(entegalha: MutableMap<Pair<String, String>, String>, khoroji: String, vorodi: String, nemadha: String) {
    val key = Pair(khoroji, vorodi)
    if (entegalha.containsKey(key)) {
        entegalha[key] = "(${entegalha[key]}+$nemadha)"
    } else {
        entegalha[key] = nemadha
    }
}

fun hazfestateha(transitionHa: MutableMap<Pair<String, String>, String>, stateHazfi: String, statesHa: Set<String>) {
    for (from in statesHa) {
        for (to in statesHa) {
            if (from != stateHazfi && to != stateHazfi && transitionHa.containsKey(Pair(from, stateHazfi)) && transitionHa.containsKey(Pair(stateHazfi, to))) {
                val loop = transitionHa[Pair(stateHazfi, stateHazfi)] ?: ""
                val transitionJadid = transitionHa[Pair(from, stateHazfi)] + (if (loop.isEmpty()) "" else "($loop)*") + transitionHa[Pair(stateHazfi, to)]
                ezafeKardaneEntegalaha(transitionHa, from, to, transitionJadid)
            }
        }
    }
    transitionHa.entries.removeIf { it.key.first == stateHazfi || it.key.second == stateHazfi }
}

fun dfabeebaratemonazam( entegalhayeDfa: List<Dfaa>): String {
    val entegalat = mutableMapOf<Pair<String, String>, String>()
    val stateha = mutableSetOf<String>()
    for (transition in entegalhayeDfa) {
        ezafeKardaneEntegalaha(entegalat, transition.khoroji, transition.vorodi, transition.nema)
        stateha.add(transition.khoroji)
        stateha.add(transition.vorodi)
    }



    for (state in stateha) {
        if (state != "qs" && state != "qf") {
            hazfestateha(entegalat, state, stateha)
        }
    }

    return entegalat[Pair("qs", "qf")] ?: ""
}