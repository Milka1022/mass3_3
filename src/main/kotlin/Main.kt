fun main() {
    val alphabet = arrayOf('А','Б','В','Г','Д','Е','Ё','Ж','З','И','Й','К','Л','М','Н','О','П','Р','С','Т','У','Ф','Х','Ц','Ч','Ш','Щ','Ь','Ы','Ъ','Э','Ю','Я')
    val numbers = arrayOf(21,13,4,20,22,1,25,12,24,14,2,28,9,23,3,29,6,16,15,11,26,5,30,27,8,18,10,33,31,32,19,7,17)
    println("Шифровать или дешифровать текст? (зашифровать/дешифровать)")
    val choice = readLine()!!.toLowerCase()

    if (choice == "зашифровать") {
        println("Введите ключевое слово:")
        val keyword = readLine()!!.toUpperCase()
        println("Введите исходный текст:")
        val text = readLine()!!.toUpperCase()

        var index = 0
        var result = ""

        for (i in text) {
            if (i in alphabet) {
                val keyLetter = keyword[index % keyword.length]
                val shift = alphabet.indexOf(keyLetter) + 1
                val newIndex = (alphabet.indexOf(i) + shift) % alphabet.size
                result += alphabet[newIndex]
                index++
            } else {
                result += i
            }
        }

        println("Зашифрованный текст: $result")

    } else if (choice == "дешифровать") {
        println("Введите ключевое слово:")
        val keyword = readLine()!!.toUpperCase()
        println("Введите зашифрованный текст:")
        val text = readLine()!!.toUpperCase()

        var index = 0
        var result = ""

        for (i in text) {
            if (i in alphabet) {
                val keyLetter = keyword[index % keyword.length]
                val shift = alphabet.indexOf(keyLetter) + 1
                var newIndex = alphabet.indexOf(i) - shift
                if (newIndex < 0) {
                    newIndex += alphabet.size
                }
                result += alphabet[newIndex]
                index++
            } else {
                result += i
            }
        }

        println("Расшифрованный текст: $result")

    } else {
        println("Некорректный выбор")
    }
}