package com.sampleboard.view.photosModule;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.sampleboard.R;
import com.sampleboard.databinding.FragmentItemsBinding;
import com.sampleboard.presenters.PhotosListPresenter;
import com.sampleboard.view.DashBoardActivity;

import java.security.KeyStore;

import javax.crypto.KeyGenerator;

/**
 * Created by Mobilyte India Pvt Ltd on 2/28/2017.
 */

public class PhotosListFragment extends Fragment implements ItemView {
    FragmentItemsBinding binder;
    private PhotosListPresenter presenter;

    //For finger print sendor if user go to profile page
//    private static final String DIALOG_FRAGMENT_TAG = "myFragment";
//    private static final String SECRET_MESSAGE = "Very secret message";
//    private static final String KEY_NAME_NOT_INVALIDATED = "key_not_invalidated";
//    public static final String DEFAULT_KEY_NAME = "default_key";
//
//    private KeyStore mKeyStore;
//    private KeyGenerator mKeyGenerator;

    @Override
    public void onStart() {
        super.onStart();
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_print:
               /* //Fingerprint API only available on from Android 6.0 (M)
                boolean isFingerPrintAvailable = false;
                boolean isFingerTouchEnable = SharedPreferencesHandler.getBooleanValues(getActivity(), getString(R.string.pref_isFingertouchEnable));
                FingerprintManager fingerprintManager = (FingerprintManager) getActivity().getSystemService(Context.FINGERPRINT_SERVICE);
                if (!fingerprintManager.isHardwareDetected()) {
                    // Device doesn't support fingerprint authentication
                } else if (!fingerprintManager.hasEnrolledFingerprints()) {
                    // User hasn't enrolled any fingerprints to authenticate with
                } else {
                    // Everything is ready for fingerprint authentication
                    isFingerPrintAvailable = true;
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && isFingerPrintAvailable && isFingerTouchEnable) {
                    manageFingerPrint();
                }else{
                    Intent profileIntent = new Intent(getActivity(), ProfileActivity.class);
                    startActivity(profileIntent);
                }*/
                break;
        }
        return true;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binder = DataBindingUtil.inflate(inflater, R.layout.fragment_items,container,false);
        ((DashBoardActivity)getActivity()).setSupportActionBar(binder.toolbar);
        ((DashBoardActivity)getActivity()).getSupportActionBar().setTitle("SampleApp");
        presenter = new PhotosListPresenter(this,binder,PhotosListFragment.this);

        binder.btnListType.setOnClickListener(presenter);

        return binder.getRoot();
    }


    @Override
    public void backPress() {

    }


    /**
     * Manage FingerPrint
     *//*
    private void manageFingerPrint(){
        try {
            mKeyStore = KeyStore.getInstance("AndroidKeyStore");
        } catch (KeyStoreException e) {
            throw new RuntimeException("Failed to get an instance of KeyStore", e);
        }
        try {
            mKeyGenerator = KeyGenerator
                    .getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore");
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            throw new RuntimeException("Failed to get an instance of KeyGenerator", e);
        }
        Cipher defaultCipher;
        Cipher cipherNotInvalidated;
        try {
            defaultCipher = Cipher.getInstance(KeyProperties.KEY_ALGORITHM_AES + "/"
                    + KeyProperties.BLOCK_MODE_CBC + "/"
                    + KeyProperties.ENCRYPTION_PADDING_PKCS7);
            cipherNotInvalidated = Cipher.getInstance(KeyProperties.KEY_ALGORITHM_AES + "/"
                    + KeyProperties.BLOCK_MODE_CBC + "/"
                    + KeyProperties.ENCRYPTION_PADDING_PKCS7);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new RuntimeException("Failed to get an instance of Cipher", e);
        }
        KeyguardManager keyguardManager = getActivity().getSystemService(KeyguardManager.class);
        FingerprintManager fingerprintManager = getActivity().getSystemService(FingerprintManager.class);

        if (!keyguardManager.isKeyguardSecure()) {
            // Show a message that the user hasn't set up a fingerprint or lock screen.
            Toast.makeText(getActivity(),
                    "Secure lock screen hasn't set up.\n"
                            + "Go to 'Settings -> Security -> Fingerprint' to set up a fingerprint",
                    Toast.LENGTH_LONG).show();
            return;
        }

        // Now the protection level of USE_FINGERPRINT permission is normal instead of dangerous.
        // See http://developer.android.com/reference/android/Manifest.permission.html#USE_FINGERPRINT
        // The line below prevents the false positive inspection from Android Studio
        // noinspection ResourceType
        if (!fingerprintManager.hasEnrolledFingerprints()) {
            // This happens when no fingerprints are registered.
            Toast.makeText(getActivity(),
                    "Go to 'Settings -> Security -> Fingerprint' and register at least one fingerprint",
                    Toast.LENGTH_LONG).show();
            return;
        }
        createKey(DEFAULT_KEY_NAME, true);
        createKey(KEY_NAME_NOT_INVALIDATED, false);

        //initiate touch id container
        if (initCipher(defaultCipher, DEFAULT_KEY_NAME)){
            // Show the fingerprint dialog. The user has the option to use the fingerprint with
            // crypto, or you can fall back to using a server-side verified password.
            FingerprintAuthenticationDialogFragment fragment
                    = new FingerprintAuthenticationDialogFragment();
            fragment.setCryptoObject(new FingerprintManager.CryptoObject(defaultCipher));
//            boolean useFingerprintPreference = mSharedPreferences
//                    .getBoolean(getString(R.string.use_fingerprint_to_authenticate_key),
//                            true);
            fragment.setStage(
                    FingerprintAuthenticationDialogFragment.Stage.FINGERPRINT);
            fragment.setCurrentFragment(PhotosListFragment.this);
            fragment.show(((DashBoardActivity)getActivity()).getFragmentManager(), DIALOG_FRAGMENT_TAG);
        }else{
            Utils.getInstance().showToast("Not intitialized yet");
        }

//        new PurchaseButtonClickListener(defaultCipher, DEFAULT_KEY_NAME);

    }

    *//**
     *
     *
     * @param keyName the key name to init the cipher
     * @return {@code true} if initialization is successful, {@code false} if the lock screen has
     * been disabled or reset after the key was generated, or if a fingerprint got enrolled after
     * the key was generated.
     *//*
    private boolean initCipher(Cipher cipher, String keyName) {
        try {
            mKeyStore.load(null);
            SecretKey key = (SecretKey) mKeyStore.getKey(keyName, null);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return true;
        } catch (KeyPermanentlyInvalidatedException e) {
            return false;
        } catch (KeyStoreException | CertificateException | UnrecoverableKeyException | IOException
                | NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException("Failed to init Cipher", e);
        }
    }

    *//**
     * Creates a symmetric key in the Android Key Store which can only be used after the user has
     * authenticated with fingerprint.
     *
     * @param keyName the name of the key to be created
     * @param invalidatedByBiometricEnrollment if {@code false} is passed, the created key will not
     *                                         be invalidated even if a new fingerprint is enrolled.
     *                                         The default value is {@code true}, so passing
     *                                         {@code true} doesn't change the behavior
     *                                         (the key will be invalidated if a new fingerprint is
     *                                         enrolled.). Note that this parameter is only valid if
     *                                         the app works on Android N developer preview.
     *
     *//*
    public void createKey(String keyName, boolean invalidatedByBiometricEnrollment) {
        // The enrolling flow for fingerprint. This is where you ask the user to set up fingerprint
        // for your flow. Use of keys is necessary if you need to know if the set of
        // enrolled fingerprints has changed.
        try {
            mKeyStore.load(null);
            // Set the alias of the entry in Android KeyStore where the key will appear
            // and the constrains (purposes) in the constructor of the Builder

            KeyGenParameterSpec.Builder builder = new KeyGenParameterSpec.Builder(keyName,
                    KeyProperties.PURPOSE_ENCRYPT |
                            KeyProperties.PURPOSE_DECRYPT)
                    .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
                    // Require the user to authenticate with a fingerprint to authorize every use
                    // of the key
                    .setUserAuthenticationRequired(true)
                    .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7);

            // This is a workaround to avoid crashes on devices whose API level is < 24
            // because KeyGenParameterSpec.Builder#setInvalidatedByBiometricEnrollment is only
            // visible on API level +24.
            // Ideally there should be a compat library for KeyGenParameterSpec.Builder but
            // which isn't available yet.
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                builder.setInvalidatedByBiometricEnrollment(invalidatedByBiometricEnrollment);
            }
            mKeyGenerator.init(builder.build());
            mKeyGenerator.generateKey();
        } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException
                | CertificateException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    *//**
     * Proceed the purchase operation
     *
     * @param withFingerprint {@code true} if the purchase was made by using a fingerprint
     * @param cryptoObject the Crypto object
     *//*
    public void onPurchased(boolean withFingerprint,
                            @Nullable FingerprintManager.CryptoObject cryptoObject) {
        if (withFingerprint) {
            // If the user has authenticated with fingerprint, verify that using cryptography and
            // then show the confirmation message.
            assert cryptoObject != null;
            try {
                byte[] encrypted = cryptoObject.getCipher().doFinal(SECRET_MESSAGE.getBytes());
            } catch (BadPaddingException | IllegalBlockSizeException e) {
                Utils.getInstance().showToast("Failed to encrypt the data with the generated key.");
                Log.e("", "Failed to encrypt the data with the generated key." + e.getMessage());
            }
            //After Successful Authentication

            Intent profileIntent = new Intent(getActivity(), ProfileActivity.class);
            startActivity(profileIntent);
        } else {
            // Authentication happened with backup password. Just show the confirmation message.

        }
    }*/
}
