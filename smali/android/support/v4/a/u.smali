.class final Landroid/support/v4/a/u;
.super Ljava/lang/Object;
.source "FragmentManager.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/support/v4/a/u;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field a:[Landroid/support/v4/a/w;

.field b:[I

.field c:[Landroid/support/v4/a/e;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 390
    new-instance v0, Landroid/support/v4/a/u$1;

    invoke-direct {v0}, Landroid/support/v4/a/u$1;-><init>()V

    sput-object v0, Landroid/support/v4/a/u;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 371
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 372
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 1

    .prologue
    .line 374
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 375
    sget-object v0, Landroid/support/v4/a/w;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->createTypedArray(Landroid/os/Parcelable$Creator;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/support/v4/a/w;

    iput-object v0, p0, Landroid/support/v4/a/u;->a:[Landroid/support/v4/a/w;

    .line 376
    invoke-virtual {p1}, Landroid/os/Parcel;->createIntArray()[I

    move-result-object v0

    iput-object v0, p0, Landroid/support/v4/a/u;->b:[I

    .line 377
    sget-object v0, Landroid/support/v4/a/e;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->createTypedArray(Landroid/os/Parcelable$Creator;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/support/v4/a/e;

    iput-object v0, p0, Landroid/support/v4/a/u;->c:[Landroid/support/v4/a/e;

    .line 378
    return-void
.end method


# virtual methods
.method public final describeContents()I
    .locals 1

    .prologue
    .line 381
    const/4 v0, 0x0

    return v0
.end method

.method public final writeToParcel(Landroid/os/Parcel;I)V
    .locals 1

    .prologue
    .line 385
    iget-object v0, p0, Landroid/support/v4/a/u;->a:[Landroid/support/v4/a/w;

    invoke-virtual {p1, v0, p2}, Landroid/os/Parcel;->writeTypedArray([Landroid/os/Parcelable;I)V

    .line 386
    iget-object v0, p0, Landroid/support/v4/a/u;->b:[I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeIntArray([I)V

    .line 387
    iget-object v0, p0, Landroid/support/v4/a/u;->c:[Landroid/support/v4/a/e;

    invoke-virtual {p1, v0, p2}, Landroid/os/Parcel;->writeTypedArray([Landroid/os/Parcelable;I)V

    .line 388
    return-void
.end method