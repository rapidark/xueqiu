.class final Lcom/xueqiu/android/cube/CubeGainAnalysisActivity$4;
.super Lcom/xueqiu/android/base/b/p;
.source "CubeGainAnalysisActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xueqiu/android/cube/CubeGainAnalysisActivity;
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/xueqiu/android/base/b/p",
        "<",
        "Ljava/util/List",
        "<",
        "Lcom/xueqiu/android/cube/model/NavMonthlyList;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/xueqiu/android/cube/CubeGainAnalysisActivity;


# direct methods
.method constructor <init>(Lcom/xueqiu/android/cube/CubeGainAnalysisActivity;Lcom/xueqiu/android/base/b/q;)V
    .locals 0

    .prologue
    .line 173
    iput-object p1, p0, Lcom/xueqiu/android/cube/CubeGainAnalysisActivity$4;->a:Lcom/xueqiu/android/cube/CubeGainAnalysisActivity;

    invoke-direct {p0, p2}, Lcom/xueqiu/android/base/b/p;-><init>(Lcom/xueqiu/android/base/b/q;)V

    return-void
.end method


# virtual methods
.method public final a(Lcom/android/volley/y;)V
    .locals 1

    .prologue
    .line 176
    iget-object v0, p0, Lcom/xueqiu/android/cube/CubeGainAnalysisActivity$4;->a:Lcom/xueqiu/android/cube/CubeGainAnalysisActivity;

    invoke-static {v0}, Lcom/xueqiu/android/cube/CubeGainAnalysisActivity;->h(Lcom/xueqiu/android/cube/CubeGainAnalysisActivity;)V

    .line 177
    invoke-static {p1}, Lcom/xueqiu/android/base/util/aa;->a(Ljava/lang/Throwable;)V

    .line 178
    return-void
.end method

.method public final synthetic a(Ljava/lang/Object;)V
    .locals 1

    .prologue
    .line 173
    check-cast p1, Ljava/util/List;

    .line 1182
    iget-object v0, p0, Lcom/xueqiu/android/cube/CubeGainAnalysisActivity$4;->a:Lcom/xueqiu/android/cube/CubeGainAnalysisActivity;

    invoke-static {v0, p1}, Lcom/xueqiu/android/cube/CubeGainAnalysisActivity;->b(Lcom/xueqiu/android/cube/CubeGainAnalysisActivity;Ljava/util/List;)V

    .line 173
    return-void
.end method
