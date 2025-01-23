data class Dfa(
    val stateha: Set<String>,
    val nemadha: Set<String>,
    val entegalHa: Map<Pair<String, String>, String>,
    val stateshoro: String,
    val statePayan: Set<String>
)