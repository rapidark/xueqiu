.class final Lcom/xueqiu/android/trade/d/d$4;
.super Ljava/lang/Object;
.source "OrderFullPresenter.java"

# interfaces
.implements Lrx/c/b;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xueqiu/android/trade/d/d;
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lrx/c/b",
        "<",
        "Ljava/lang/Throwable;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/xueqiu/android/trade/d/d;


# direct methods
.method constructor <init>(Lcom/xueqiu/android/trade/d/d;)V
    .locals 0

    .prologue
    .line 214
    iput-object p1, p0, Lcom/xueqiu/android/trade/d/d$4;->a:Lcom/xueqiu/android/trade/d/d;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final synthetic a(Ljava/lang/Object;)V
    .locals 3

    .prologue
    .line 214
    check-cast p1, Ljava/lang/Throwable;

    .line 1217
    iget-object v0, p0, Lcom/xueqiu/android/trade/d/d$4;->a:Lcom/xueqiu/android/trade/d/d;

    invoke-static {v0}, Lcom/xueqiu/android/trade/d/d;->a(Lcom/xueqiu/android/trade/d/d;)V

    .line 1218
    const-string v0, "StockDetailView"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "\u80a1\u4ef7\u66f4\u65b0\u5931\u8d25 QuoteFragment"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/xueqiu/android/base/util/v;->c(Ljava/lang/String;Ljava/lang/String;)V

    .line 214
    return-void
.end method
