.class public final enum Lcom/alipay/sdk/f/a;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/alipay/sdk/f/a;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lcom/alipay/sdk/f/a;

.field public static final enum b:Lcom/alipay/sdk/f/a;

.field public static final enum c:Lcom/alipay/sdk/f/a;

.field public static final enum d:Lcom/alipay/sdk/f/a;

.field public static final enum e:Lcom/alipay/sdk/f/a;

.field public static final enum f:Lcom/alipay/sdk/f/a;

.field public static final enum g:Lcom/alipay/sdk/f/a;

.field private static final synthetic v:[Lcom/alipay/sdk/f/a;


# instance fields
.field public h:Ljava/lang/String;

.field private i:Ljava/lang/String;

.field private j:Ljava/lang/String;

.field private k:Lorg/json/JSONObject;

.field private l:Ljava/lang/String;

.field private m:Ljava/lang/String;

.field private n:Ljava/lang/String;

.field private o:Z

.field private p:Z

.field private q:Z

.field private r:Ljava/lang/String;

.field private s:Ljava/lang/String;

.field private t:Ljava/lang/String;

.field private u:Lorg/json/JSONObject;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    new-instance v0, Lcom/alipay/sdk/f/a;

    const-string v1, "WapPay"

    const-string v2, "js://wappay"

    invoke-direct {v0, v1, v4, v2}, Lcom/alipay/sdk/f/a;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/alipay/sdk/f/a;->a:Lcom/alipay/sdk/f/a;

    new-instance v0, Lcom/alipay/sdk/f/a;

    const-string v1, "DownLoad"

    const-string v2, "js://download"

    invoke-direct {v0, v1, v5, v2}, Lcom/alipay/sdk/f/a;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/alipay/sdk/f/a;->b:Lcom/alipay/sdk/f/a;

    new-instance v0, Lcom/alipay/sdk/f/a;

    const-string v1, "Submit"

    const-string v2, "submit"

    invoke-direct {v0, v1, v6, v2}, Lcom/alipay/sdk/f/a;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/alipay/sdk/f/a;->c:Lcom/alipay/sdk/f/a;

    new-instance v0, Lcom/alipay/sdk/f/a;

    const-string v1, "Confirm"

    const-string v2, "js://confirm"

    invoke-direct {v0, v1, v7, v2}, Lcom/alipay/sdk/f/a;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/alipay/sdk/f/a;->d:Lcom/alipay/sdk/f/a;

    new-instance v0, Lcom/alipay/sdk/f/a;

    const-string v1, "Alert"

    const-string v2, "js://alert"

    invoke-direct {v0, v1, v8, v2}, Lcom/alipay/sdk/f/a;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/alipay/sdk/f/a;->e:Lcom/alipay/sdk/f/a;

    new-instance v0, Lcom/alipay/sdk/f/a;

    const-string v1, "Update"

    const/4 v2, 0x5

    const-string v3, "js://update"

    invoke-direct {v0, v1, v2, v3}, Lcom/alipay/sdk/f/a;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/alipay/sdk/f/a;->f:Lcom/alipay/sdk/f/a;

    new-instance v0, Lcom/alipay/sdk/f/a;

    const-string v1, "Exit"

    const/4 v2, 0x6

    const-string v3, "js://exit"

    invoke-direct {v0, v1, v2, v3}, Lcom/alipay/sdk/f/a;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/alipay/sdk/f/a;->g:Lcom/alipay/sdk/f/a;

    const/4 v0, 0x7

    new-array v0, v0, [Lcom/alipay/sdk/f/a;

    sget-object v1, Lcom/alipay/sdk/f/a;->a:Lcom/alipay/sdk/f/a;

    aput-object v1, v0, v4

    sget-object v1, Lcom/alipay/sdk/f/a;->b:Lcom/alipay/sdk/f/a;

    aput-object v1, v0, v5

    sget-object v1, Lcom/alipay/sdk/f/a;->c:Lcom/alipay/sdk/f/a;

    aput-object v1, v0, v6

    sget-object v1, Lcom/alipay/sdk/f/a;->d:Lcom/alipay/sdk/f/a;

    aput-object v1, v0, v7

    sget-object v1, Lcom/alipay/sdk/f/a;->e:Lcom/alipay/sdk/f/a;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/alipay/sdk/f/a;->f:Lcom/alipay/sdk/f/a;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/alipay/sdk/f/a;->g:Lcom/alipay/sdk/f/a;

    aput-object v2, v0, v1

    sput-object v0, Lcom/alipay/sdk/f/a;->v:[Lcom/alipay/sdk/f/a;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    iput-object p3, p0, Lcom/alipay/sdk/f/a;->i:Ljava/lang/String;

    return-void
.end method

.method public static a(Lcom/alipay/sdk/f/b;)[Lcom/alipay/sdk/f/a;
    .locals 13

    const/4 v3, 0x1

    const/4 v4, 0x0

    if-eqz p0, :cond_4

    iget-object v1, p0, Lcom/alipay/sdk/f/b;->a:Ljava/lang/String;

    const/4 v0, 0x0

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_6

    const-string v0, ";"

    invoke-virtual {v1, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    move-object v7, v0

    :goto_0
    if-nez v7, :cond_0

    new-array v0, v3, [Lcom/alipay/sdk/f/a;

    sget-object v1, Lcom/alipay/sdk/f/a;->c:Lcom/alipay/sdk/f/a;

    aput-object v1, v0, v4

    :goto_1
    return-object v0

    :cond_0
    array-length v0, v7

    new-array v2, v0, [Lcom/alipay/sdk/f/a;

    array-length v8, v7

    move v3, v4

    move v5, v4

    :goto_2
    if-ge v3, v8, :cond_3

    aget-object v9, v7, v3

    sget-object v1, Lcom/alipay/sdk/f/a;->c:Lcom/alipay/sdk/f/a;

    invoke-static {}, Lcom/alipay/sdk/f/a;->values()[Lcom/alipay/sdk/f/a;

    move-result-object v10

    array-length v11, v10

    move v6, v4

    :goto_3
    if-ge v6, v11, :cond_5

    aget-object v0, v10, v6

    iget-object v12, v0, Lcom/alipay/sdk/f/a;->i:Ljava/lang/String;

    invoke-virtual {v9, v12}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_2

    :goto_4
    iput-object v9, v0, Lcom/alipay/sdk/f/a;->h:Ljava/lang/String;

    iget-object v1, p0, Lcom/alipay/sdk/f/b;->b:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    sget-object v1, Lcom/alipay/sdk/a/a;->a:Ljava/lang/String;

    iput-object v1, p0, Lcom/alipay/sdk/f/b;->b:Ljava/lang/String;

    :cond_1
    iget-object v1, p0, Lcom/alipay/sdk/f/b;->b:Ljava/lang/String;

    iput-object v1, v0, Lcom/alipay/sdk/f/a;->j:Ljava/lang/String;

    invoke-virtual {p0}, Lcom/alipay/sdk/f/b;->a()Lorg/json/JSONObject;

    move-result-object v1

    iput-object v1, v0, Lcom/alipay/sdk/f/a;->k:Lorg/json/JSONObject;

    iget-object v1, p0, Lcom/alipay/sdk/f/b;->c:Ljava/lang/String;

    iput-object v1, v0, Lcom/alipay/sdk/f/a;->l:Ljava/lang/String;

    iget-object v1, p0, Lcom/alipay/sdk/f/b;->d:Ljava/lang/String;

    iput-object v1, v0, Lcom/alipay/sdk/f/a;->m:Ljava/lang/String;

    iget-object v1, p0, Lcom/alipay/sdk/f/b;->e:Ljava/lang/String;

    iput-object v1, v0, Lcom/alipay/sdk/f/a;->n:Ljava/lang/String;

    iget-boolean v1, p0, Lcom/alipay/sdk/f/b;->f:Z

    iput-boolean v1, v0, Lcom/alipay/sdk/f/a;->o:Z

    iget-boolean v1, p0, Lcom/alipay/sdk/f/b;->g:Z

    iput-boolean v1, v0, Lcom/alipay/sdk/f/a;->p:Z

    iget-boolean v1, p0, Lcom/alipay/sdk/f/b;->h:Z

    iput-boolean v1, v0, Lcom/alipay/sdk/f/a;->q:Z

    iget-object v1, p0, Lcom/alipay/sdk/f/b;->i:Ljava/lang/String;

    iput-object v1, v0, Lcom/alipay/sdk/f/a;->r:Ljava/lang/String;

    iget-object v1, p0, Lcom/alipay/sdk/f/b;->j:Ljava/lang/String;

    iput-object v1, v0, Lcom/alipay/sdk/f/a;->s:Ljava/lang/String;

    iget-object v1, p0, Lcom/alipay/sdk/f/b;->k:Ljava/lang/String;

    iput-object v1, v0, Lcom/alipay/sdk/f/a;->t:Ljava/lang/String;

    iget-object v1, p0, Lcom/alipay/sdk/f/b;->l:Lorg/json/JSONObject;

    iput-object v1, v0, Lcom/alipay/sdk/f/a;->u:Lorg/json/JSONObject;

    aput-object v0, v2, v5

    add-int/lit8 v1, v5, 0x1

    add-int/lit8 v0, v3, 0x1

    move v3, v0

    move v5, v1

    goto :goto_2

    :cond_2
    add-int/lit8 v0, v6, 0x1

    move v6, v0

    goto :goto_3

    :cond_3
    move-object v0, v2

    goto :goto_1

    :cond_4
    new-array v0, v3, [Lcom/alipay/sdk/f/a;

    sget-object v1, Lcom/alipay/sdk/f/a;->c:Lcom/alipay/sdk/f/a;

    aput-object v1, v0, v4

    goto :goto_1

    :cond_5
    move-object v0, v1

    goto :goto_4

    :cond_6
    move-object v7, v0

    goto :goto_0
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/alipay/sdk/f/a;
    .locals 1

    const-class v0, Lcom/alipay/sdk/f/a;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/alipay/sdk/f/a;

    return-object v0
.end method

.method public static values()[Lcom/alipay/sdk/f/a;
    .locals 1

    sget-object v0, Lcom/alipay/sdk/f/a;->v:[Lcom/alipay/sdk/f/a;

    invoke-virtual {v0}, [Lcom/alipay/sdk/f/a;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/alipay/sdk/f/a;

    return-object v0
.end method
