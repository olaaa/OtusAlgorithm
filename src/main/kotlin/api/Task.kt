package api

interface Task {
 fun run(data: List<String>): String
}