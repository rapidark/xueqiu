.class public final Lcom/xiaomi/push/service/an;
.super Ljava/lang/Object;


# static fields
.field private static c:Lcom/xiaomi/push/service/an;


# instance fields
.field a:Landroid/content/Context;

.field b:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/4 v0, 0x0

    sput-object v0, Lcom/xiaomi/push/service/an;->c:Lcom/xiaomi/push/service/an;

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .locals 5

    const/4 v0, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lcom/xiaomi/push/service/an;->b:Ljava/util/List;

    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iput-object v1, p0, Lcom/xiaomi/push/service/an;->a:Landroid/content/Context;

    iget-object v1, p0, Lcom/xiaomi/push/service/an;->a:Landroid/content/Context;

    if-nez v1, :cond_0

    iput-object p1, p0, Lcom/xiaomi/push/service/an;->a:Landroid/content/Context;

    :cond_0
    iget-object v1, p0, Lcom/xiaomi/push/service/an;->a:Landroid/content/Context;

    const-string v2, "mipush_app_info"

    invoke-virtual {v1, v2, v0}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    const-string v2, "unregistered_pkg_names"

    const-string v3, ""

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, ","

    invoke-virtual {v1, v2}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    array-length v2, v1

    :goto_0
    if-ge v0, v2, :cond_2

    aget-object v3, v1, v0

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_1

    iget-object v4, p0, Lcom/xiaomi/push/service/an;->b:Ljava/util/List;

    invoke-interface {v4, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_2
    return-void
.end method

.method public static a(Landroid/content/Context;)Lcom/xiaomi/push/service/an;
    .locals 1

    sget-object v0, Lcom/xiaomi/push/service/an;->c:Lcom/xiaomi/push/service/an;

    if-nez v0, :cond_0

    new-instance v0, Lcom/xiaomi/push/service/an;

    invoke-direct {v0, p0}, Lcom/xiaomi/push/service/an;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/xiaomi/push/service/an;->c:Lcom/xiaomi/push/service/an;

    :cond_0
    sget-object v0, Lcom/xiaomi/push/service/an;->c:Lcom/xiaomi/push/service/an;

    return-object v0
.end method


# virtual methods
.method public final a(Ljava/lang/String;)Z
    .locals 2

    iget-object v1, p0, Lcom/xiaomi/push/service/an;->b:Ljava/util/List;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lcom/xiaomi/push/service/an;->b:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    monitor-exit v1

    return v0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method