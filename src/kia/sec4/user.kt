//class User(val nickname: String)

//class User constructor(nickname: String) {
//    val nickname: String
//
//    init {
//        this.nickname = nickname
//    }
//}

class User(_nickname: String) {
    val nickname = _nickname
}

interface Context
interface AttributeSet

open class View {
    constructor(ctx: Context) {}
    constructor(ctx: Context, attr: AttributeSet) {}
}

class MyButton: View {
    constructor(ctx: Context) : super(ctx) {}
    constructor(ctx: Context, attr: AttributeSet): super(ctx, attr) {}
}

class OtherMyButton: View {
//    constructor(ctx: Context): this(ctx, MY_STYLE) {}
    constructor(ctx: Context, attr: AttributeSet): super(ctx, attr) {}
}


