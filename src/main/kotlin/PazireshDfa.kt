class PazireshDfa(val dfa:Dfa) {

    fun isDFA(): Boolean {
        val vaziyat = dfa.stateha
        val vorodi = dfa.nemadha
        val enteghal = dfa.entegalHa
        val vaziyatShoro = dfa.stateshoro
        val vaziyatPayan = dfa.statePayan

        //  ostad dar inja barasi mikonim ke har vorodi dagiga yek entegal dashte bashe

        for (state in vaziyat) {
            for (input in vorodi) {
                val kelidEnteqal = Pair(state, input)
                if (!enteghal.containsKey(kelidEnteqal)) {
                    println(" entegal baraye halate $state va vorodi $input tarif nashode ast")
                    return false
                }
            }
        }

        //ostad inja barasi mikonim ke halat payani dar majmoe halat bashe
        if (!vaziyat.containsAll(vaziyatPayan)) {
            println(" yek ya chand halate payani dar majmoe halatha vojod nadarad ")
            return false
        }

        // ostad inja barasi mikonim ke halat shoro bayad to majmoe halat bashe
        if (!vaziyat.contains(vaziyatShoro)) {
            println(" halat shoro dar majmoe halatha tarif nashode ast")
            return false
        }

        // inja barasi mikonim ke tamami klid haye entegal motabar bashad

        for ((key, value) in enteghal) {
            if (key.first !in vaziyat || key.second !in vorodi || value !in vaziyat) {
                println("entegale  bara halate  ${key.first} va vorodi ${key.second} vojod nadarad")
                return false
            }
        }

        //  agar dfa motabar bashad dastor payini chap mishe va true return mishe
        println("mashin dfa motabar ast")
        return true
    }
}